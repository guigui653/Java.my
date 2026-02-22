USE biblioteca;

-- Limpa tudo na ordem certa
DROP TABLE IF EXISTS emprestimos;
DROP TABLE IF EXISTS livros;
DROP TABLE IF EXISTS usuarios;

-- Cria tabelas completas já com todos os campos
CREATE TABLE livros (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        titulo VARCHAR(150) NOT NULL,
                        autor VARCHAR(100) NOT NULL,
                        isbn VARCHAR(20) UNIQUE,
                        quantidade INT DEFAULT 0,
                        categoria VARCHAR(50) DEFAULT 'Geral'
);

CREATE TABLE usuarios (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          nome VARCHAR(100) NOT NULL,
                          email VARCHAR(100) UNIQUE NOT NULL,
                          telefone VARCHAR(20)
);

CREATE TABLE emprestimos (
                             id INT AUTO_INCREMENT PRIMARY KEY,
                             livro_id INT NOT NULL,
                             usuario_id INT NOT NULL,
                             data_emprestimo DATE NOT NULL,
                             data_prevista_devolucao DATE,
                             data_devolucao DATE,
                             status ENUM('ATIVO', 'DEVOLVIDO') DEFAULT 'ATIVO',
                             FOREIGN KEY (livro_id) REFERENCES livros(id),
                             FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

-- ==================== USUÁRIOS ====================
INSERT INTO usuarios (nome, email, telefone) VALUES
                                                 ('João Silva',       'joao@email.com',     '11999991111'),
                                                 ('Maria Oliveira',   'maria@email.com',    '11999992222'),
                                                 ('Carlos Santos',    'carlos@email.com',   '11999993333'),
                                                 ('Ana Souza',        'ana@email.com',      '11999994444'),
                                                 ('Pedro Lima',       'pedro@email.com',    '11999995555'),
                                                 ('Fernanda Costa',   'fernanda@email.com', '11999996666'),
                                                 ('Lucas Mendes',     'lucas@email.com',    '11999997777'),
                                                 ('Juliana Rocha',    'juliana@email.com',  '11999998888');

-- ==================== LIVROS ====================
INSERT INTO livros (titulo, autor, isbn, quantidade, categoria) VALUES
-- Tecnologia
('Clean Code',                    'Robert C. Martin',   '978-0132350884', 3, 'Tecnologia'),
('O Programador Pragmático',      'Andrew Hunt',        '978-0135957059', 2, 'Tecnologia'),
('Código Limpo em Java',          'Robert C. Martin',   '978-0136083238', 4, 'Tecnologia'),
('Domain-Driven Design',          'Eric Evans',         '978-0321125217', 2, 'Tecnologia'),
('Arquitetura Limpa',             'Robert C. Martin',   '978-0134494166', 3, 'Tecnologia'),
('Refactoring',                   'Martin Fowler',      '978-0134757599', 1, 'Tecnologia'),
('Design Patterns',               'Gang of Four',       '978-0201633610', 2, 'Tecnologia'),

-- Ciência
('Uma Breve História do Tempo',   'Stephen Hawking',    '978-0553380163', 5, 'Ciência'),
('O Gene Egoísta',                'Richard Dawkins',    '978-0198788607', 3, 'Ciência'),
('Cosmos',                        'Carl Sagan',         '978-0345539434', 4, 'Ciência'),
('Sapiens',                       'Yuval Noah Harari',  '978-0062316097', 6, 'Ciência'),

-- Filosofia
('A República',                   'Platão',             '978-0140449143', 3, 'Filosofia'),
('Meditações',                    'Marco Aurélio',      '978-0140449334', 4, 'Filosofia'),
('Assim Falou Zaratustra',        'Friedrich Nietzsche','978-0140441185', 2, 'Filosofia'),

-- Ficção
('1984',                          'George Orwell',      '978-0451524935', 5, 'Ficção'),
('O Senhor dos Anéis',            'J.R.R. Tolkien',     '978-0618640157', 3, 'Ficção'),
('Fundação',                      'Isaac Asimov',       '978-0553293357', 4, 'Ficção'),
('Duna',                          'Frank Herbert',      '978-0441172719', 2, 'Ficção'),
('Admirável Mundo Novo',          'Aldous Huxley',      '978-0060850524', 3, 'Ficção'),

-- História
('Sapiens: De Animais a Deuses',  'Yuval Noah Harari',  '978-0771038518', 4, 'História'),
('O Príncipe',                    'Maquiavel',          '978-0486272740', 5, 'História'),

-- Romance
('Dom Casmurro',                  'Machado de Assis',   '978-8572328197', 6, 'Romance'),
('Grande Sertão: Veredas',        'João Guimarães Rosa','978-8503009843', 3, 'Romance'),
('Memórias Póstumas de Brás Cubas','Machado de Assis',  '978-8508177325', 4, 'Romance');

-- ==================== EMPRÉSTIMOS ====================
-- Empréstimos devolvidos (histórico)
INSERT INTO emprestimos (livro_id, usuario_id, data_emprestimo, data_prevista_devolucao, data_devolucao, status) VALUES
                                                                                                                     (1,  1, '2026-01-05', '2026-01-19', '2026-01-18', 'DEVOLVIDO'),
                                                                                                                     (8,  2, '2026-01-08', '2026-01-22', '2026-01-20', 'DEVOLVIDO'),
                                                                                                                     (15, 3, '2026-01-10', '2026-01-24', '2026-01-23', 'DEVOLVIDO'),
                                                                                                                     (12, 4, '2026-01-15', '2026-01-29', '2026-01-28', 'DEVOLVIDO'),
                                                                                                                     (17, 5, '2026-01-20', '2026-02-03', '2026-02-02', 'DEVOLVIDO'),
                                                                                                                     (3,  6, '2026-01-25', '2026-02-08', '2026-02-07', 'DEVOLVIDO'),
                                                                                                                     (22, 7, '2026-02-01', '2026-02-15', '2026-02-14', 'DEVOLVIDO'),
                                                                                                                     (10, 8, '2026-02-03', '2026-02-17', '2026-02-15', 'DEVOLVIDO'),

-- Empréstimos ativos (em andamento)
                                                                                                                     (2,  1, '2026-02-10', '2026-02-24', NULL, 'ATIVO'),
                                                                                                                     (5,  2, '2026-02-12', '2026-02-26', NULL, 'ATIVO'),
                                                                                                                     (16, 3, '2026-02-14', '2026-02-28', NULL, 'ATIVO'),
                                                                                                                     (9,  4, '2026-02-15', '2026-03-01', NULL, 'ATIVO'),
                                                                                                                     (19, 5, '2026-02-17', '2026-03-03', NULL, 'ATIVO'),

-- Empréstimos ativos com prazo vencido (para testar o alerta ⚠️)
                                                                                                                     (6,  6, '2026-01-20', '2026-02-03', NULL, 'ATIVO'),
                                                                                                                     (13, 7, '2026-01-22', '2026-02-05', NULL, 'ATIVO');

-- Confirma
SELECT 'Usuários:' AS info, COUNT(*) AS total FROM usuarios
UNION ALL
SELECT 'Livros:', COUNT(*) FROM livros
UNION ALL
SELECT 'Empréstimos:', COUNT(*) FROM emprestimos
UNION ALL
SELECT 'Ativos:', COUNT(*) FROM emprestimos WHERE status = 'ATIVO'
UNION ALL
SELECT 'Devolvidos:', COUNT(*) FROM emprestimos WHERE status = 'DEVOLVIDO';