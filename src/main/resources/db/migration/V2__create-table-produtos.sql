CREATE TABLE produtos (
                            id int NOT NULL AUTO_INCREMENT,
                            nome varchar(100) NOT NULL,
                            descricao varchar(100) NOT NULL,
                            preco double NOT NULL,
                            fabricante_id int,

                            PRIMARY KEY (id),
                            FOREIGN KEY (fabricante_id) REFERENCES fabricantes (id)
)