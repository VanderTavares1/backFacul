CREATE TABLE usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR NOT NULL,
    curso VARCHAR(100),
    ano_conclusao INT,
    data_cadastro DATE
);

CREATE TABLE empregos (
    id SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL,
    descricao TEXT NOT NULL,
    empresa VARCHAR(100),
    localizacao VARCHAR(100),
    tipo_contrato VARCHAR(50),
    data_postagem DATE,
    usuario_id INT REFERENCES usuarios(id) ON DELETE CASCADE
);

CREATE TABLE comentarios (
    id SERIAL PRIMARY KEY,
    texto TEXT NOT NULL,
    data_comentario DATE,
    usuario_id INT REFERENCES usuarios(id) ON DELETE CASCADE,
    emprego_id INT REFERENCES empregos(id) ON DELETE CASCADE
);