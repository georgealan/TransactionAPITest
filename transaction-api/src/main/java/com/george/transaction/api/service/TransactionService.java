package com.george.transaction.api.service;

import com.george.transaction.api.model.Transaction;
import com.george.transaction.api.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction salvar(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public Transaction atualizar(Long codigo, Transaction transaction){
        Transaction transactionSalvo = buscarLancamentoPeloCodigo(codigo);
        BeanUtils.copyProperties(transaction, transactionSalvo, "codigo");
        return transactionRepository.save(transactionSalvo);
    }

    public Transaction buscarLancamentoPeloCodigo(Long codigo) {
        Transaction transactionSalvo = transactionRepository.findOne(codigo);
        if (transactionSalvo == null){
            throw new EmptyResultDataAccessException(1);
        }
        return transactionSalvo;
    }
}
