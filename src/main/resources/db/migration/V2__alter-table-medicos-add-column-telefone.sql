
ALTER TABLE medicos ADD COLUMN telefone VARCHAR(20);

UPDATE medicos SET telefone = 'desconhecido';


ALTER TABLE medicos ALTER COLUMN telefone SET NOT NULL;