CREATE TABLE public.tarefas (
	id uuid NOT NULL,
	descricao varchar(255) NULL,
	nome varchar(255) NOT NULL,
	prioridade int4 NOT NULL,
	realizado bool NOT NULL,
	usuario_id int8 NULL,
	CONSTRAINT tarefas_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tarefas ADD CONSTRAINT fk2vwr1gcbcpkerkhk9ktxxbep FOREIGN KEY (usuario_id) REFERENCES public.usuarios(id);

CREATE TABLE public.usuarios (
	id int8 NOT NULL,
	email varchar(255) NOT NULL,
	nome varchar(255) NOT NULL,
	senha varchar(255) NOT NULL,
	CONSTRAINT ukkfsp0s1tflm1cwlj8idhqsad0 UNIQUE (email),
	CONSTRAINT usuarios_pkey PRIMARY KEY (id)
);