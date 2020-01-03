CREATE TABLE transaction (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	data DATE NOT NULL,
	time TIME NOT NULL,
	value DECIMAL(10,2) NOT NULL,
	card VARCHAR(20) NOT NULL,
	status VARCHAR(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 6500.00, 'DEBITO', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/02/10', '13:52:33', 100.32, 'CREDITO', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 120, 'VOUCHER', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/02/10', '13:52:33', 110.44, 'CREDITO', 'CANCELED');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 200.30, 'VOUCHER', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/03/10', '13:52:33', 1010.32, 'VOUCHER', 'PENDING');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 500, 'DEBITO', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/03/10', '13:52:33', 400.32, 'CREDITO', 'CANCELED');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 123.64, 'DEBITO', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/04/10', '13:52:33', 665.33, 'CREDITO', 'CANCELED');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 8.32, 'CREDITO', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/04/10', '13:52:33', 2100.32, 'VOUCHER', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 1040.32, 'DEBITO', 'PENDING');
INSERT INTO transaction (data, time, value, card, status) values ('2017/04/10', '13:52:33', 4.32, 'CREDITO', 'SUCCESS');
INSERT INTO transaction (data, time, value, card, status) values ('2017/06/10', '13:52:33', 10.20, 'DEBITO', 'PENDING');
