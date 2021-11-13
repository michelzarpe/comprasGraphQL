create table cliente (
    id    bigint auto_increment primary key,
    email varchar(255) null,
    nome  varchar(255) null
);

create table produto(
    id    bigint auto_increment primary key,
    nome  varchar(255) null,
    valor double       not null
);

create table compra
(
    id         bigint auto_increment primary key,
    data       datetime     null,
    quantidade int          null,
    status     varchar(255) null,
    cliente_id bigint       null,
    produto_id bigint       null,
    constraint FK_COMPRA_PRODUTO foreign key (produto_id) references produto (id),
    constraint FK_COMPRA_CLIENTE foreign key (cliente_id) references cliente (id)
);


INSERT INTO cliente (id, email, nome) VALUES (1, 'a@a.com', 'Cliente A');
INSERT INTO cliente (id, email, nome) VALUES (2, 'b@b.com', 'Cliente B');
INSERT INTO cliente (id, email, nome) VALUES (3, 'c@c.com', 'Cliente C');

INSERT INTO produto (id, nome, valor) VALUES (1, 'Boné', 25);
INSERT INTO produto (id, nome, valor) VALUES (2, 'Bola', 120);
INSERT INTO produto (id, nome, valor) VALUES (3, 'Bermuda', 60);
INSERT INTO produto (id, nome, valor) VALUES (4, 'Camiseta', 80);
INSERT INTO produto (id, nome, valor) VALUES (5, 'Chuteira', 130);

INSERT INTO compra (id, quantidade, data, produto_id, cliente_id, status) VALUES (1, 1, CURRENT_DATE(), 1, 1, 'OK' );
INSERT INTO compra (id, quantidade, data, produto_id, cliente_id, status) VALUES (2, 1, CURRENT_DATE(), 2, 1, 'OK' );
INSERT INTO compra (id, quantidade, data, produto_id, cliente_id, status) VALUES (3, 1, CURRENT_DATE(), 3, 1, 'OK' );
INSERT INTO compra (id, quantidade, data, produto_id, cliente_id, status) VALUES (4, 1, CURRENT_DATE(), 1, 2, 'OK' );
INSERT INTO compra (id, quantidade, data, produto_id, cliente_id, status) VALUES (5, 1, CURRENT_DATE(), 2, 2, 'OK' );

