package com.george.transaction.api.resource;


import com.george.transaction.api.event.RecursoCriadoEvent;
import com.george.transaction.api.model.Transaction;
import com.george.transaction.api.repository.TransactionRepository;
import com.george.transaction.api.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionResource {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @Autowired
    private MessageSource messageSource;

    /**
     * Método responsável por listar todos os recursos de Lançamentos.
     *
     * @return
     */
    @GetMapping("/all")
    public List<Transaction> listar() {
        return transactionRepository.findAll();
    }

    /**
     * Método responsável pela pesquisa de um recurso pelo código e retorna apenas um resultado.
     *
     * @param codigo
     * @return
     */
    @GetMapping("/{codigo}")
    public ResponseEntity<Transaction> listarPeloCodigo(@PathVariable Long codigo) {
        Transaction transaction = transactionRepository.findOne(codigo);
        return transaction != null ? ResponseEntity.ok(transaction) : ResponseEntity.notFound().build();
    }

    /**
     * Método responsável por criar um novo objeto lançamento.
     * Utilizando a classe LançamentoService para tratar as regras de negócio.
     *
     * @param transaction
     * @param response
     * @return
     */
    @PostMapping
    public ResponseEntity<Transaction> criarLancamento(@Valid @RequestBody Transaction transaction, HttpServletResponse response) {
        Transaction transactionSalvo = transactionService.salvar(transaction);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, transactionSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(transactionSalvo);
    }

    /**
     * Método responsavel por atualizar o objeto Lancamento pelo código.
     * @param codigo
     * @param transaction
     * @return
     */
    @PutMapping("/{codigo}")
    public ResponseEntity<Transaction> atualizarLancamento(@PathVariable Long codigo, @Valid @RequestBody Transaction transaction){
        Transaction transactionSalvo = transactionService.atualizar(codigo, transaction);
        return ResponseEntity.ok(transactionSalvo);
    }

}
