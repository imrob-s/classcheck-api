-- Inserir alunos (Students)
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (1, 'Maria Silva', '12345678900', '1122334455', 'maria@example.com', 'mariasilva', 'https://example.com/maria.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (2, 'João Santos', '98765432100', '5544332211', 'joao@example.com', 'joaosantos', 'https://example.com/joao.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (3, 'Ana Oliveira', '98765432101', '9988776655', 'ana@example.com', 'anaoliveira', 'https://example.com/ana.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (4, 'Pedro Souza', '98765432102', '1122334455', 'pedro@example.com', 'pedrosouza', 'https://example.com/pedro.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (5, 'Carla Pereira', '98765432103', '9988776655', 'carla@example.com', 'carlapereira', 'https://example.com/carla.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (6, 'Bruno Lima', '98765432104', '1122334455', 'bruno@example.com', 'brunolima', 'https://example.com/bruno.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (7, 'Amanda Costa', '98765432105', '9988776655', 'amanda@example.com', 'amandacosta', 'https://example.com/amanda.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (8, 'Lucas Martins', '98765432106', '1122334455', 'lucas@example.com', 'lucasmartins', 'https://example.com/lucas.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (9, 'Juliana Almeida', '98765432107', '9988776655', 'juliana@example.com', 'julianaalmeida', 'https://example.com/juliana.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (10, 'Rafael Oliveira', '98765432108', '1122334455', 'rafael@example.com', 'rafaeloliveira', 'https://example.com/rafael.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (11, 'Aline Fernandes', '98765432109', '9988776655', 'aline@example.com', 'alinefernandes', 'https://example.com/aline.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (12, 'Marcos Lima', '98765432110', '1122334455', 'marcos@example.com', 'marcoslima', 'https://example.com/marcos.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (13, 'Fernanda Pereira', '98765432111', '9988776655', 'fernanda@example.com', 'fernandapereira', 'https://example.com/fernanda.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (14, 'Thiago Silva', '98765432112', '1122334455', 'thiago@example.com', 'thiagosilva', 'https://example.com/thiago.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (15, 'Vanessa Souza', '98765432113', '9988776655', 'vanessa@example.com', 'vanessasouza', 'https://example.com/vanessa.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (16, 'Gabriel Santos', '98765432114', '1122334455', 'gabriel@example.com', 'gabrielsantos', 'https://example.com/gabriel.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (17, 'Camila Oliveira', '98765432115', '9988776655', 'camila@example.com', 'camilaoliveira', 'https://example.com/camila.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (18, 'Diego Costa', '98765432116', '1122334455', 'diego@example.com', 'diegocosta', 'https://example.com/diego.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (19, 'Tatiane Almeida', '98765432117', '9988776655', 'tatiane@example.com', 'tatianealmeida', 'https://example.com/tatiane.jpg');
INSERT INTO tb_student (id, name, cpf, phone_number, email, github, img_url) VALUES (20, 'Roberto Martins', '98765432118', '1122334455', 'roberto@example.com', 'robertomartins', 'https://example.com/roberto.jpg');

-- Inserir cursos (Courses)
INSERT INTO tb_course (name) VALUES ('Logica de Programação');
INSERT INTO tb_course (name) VALUES ('Introdução à Computadores');
INSERT INTO tb_course (name) VALUES ('Java Básico');
INSERT INTO tb_course (name) VALUES ('Banco de Dados');

-- Inserir presenças (Attendances)
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-20 08:00:00', 1, 1);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-20 08:00:00', 2, 1);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-21 08:00:00', 3, 2);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-21 08:00:00', 4, 2);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-22 08:00:00', 5, 3);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-22 08:00:00', 6, 3);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-23 08:00:00', 7, 4);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-23 08:00:00', 8, 4);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-24 08:00:00', 9, 1);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-24 08:00:00', 10, 1);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-25 08:00:00', 11, 2);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-25 08:00:00', 12, 2);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-26 08:00:00', 13, 3);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-26 08:00:00', 14, 3);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-27 08:00:00', 15, 4);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-27 08:00:00', 16, 4);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-28 08:00:00', 17, 1);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-28 08:00:00', 18, 1);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-29 08:00:00', 19, 2);
INSERT INTO tb_attendance (date_time, student_id, course_id) VALUES ('2024-02-29 08:00:00', 20, 2);