

CREATE TABLE topicos (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    mensaje VARCHAR(255) NOT NULL,
    fechaCreacion DATETIME NOT NULL,
    estado VARCHAR(50) DEFAULT 'ABIERTO',
    autor BIGINT NOT NULL,
    FOREIGN KEY (autor) REFERENCES usuario(id)
);
