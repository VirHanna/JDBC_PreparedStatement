-- Працівники
INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
('John Doe', '1990-01-01', 'Senior', 6000),
('Jane Smith', '1995-02-02', 'Middle', 4000),
('Ivan Gdanov', '1998-03-03', 'Junior', 1500),
('Oleg Bushlia', '2000-04-04', 'Trainee', 900),
('Michael Brown', '1985-11-30', 'Senior', 7000),
('Emily Wilson', '1998-07-05', 'Middle', 4500),
('Kevin Garcia', '2001-09-12', 'Junior', 3000),
('Jessica Rodriguez', '2003-01-28', 'Trainee', 900),
('Brian Martinez', '1988-04-18', 'Senior', 6500),
('Ashley Anderson', '1997-12-01', 'Middle', 5000);

-- Клієнти
INSERT INTO client (NAME) VALUES
('ACME Corp'),
('Globex Inc'),
('Fenix Corp'),
('Amazon Inc'),
('Glam Inc');

-- Проєкти
INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
(1, '2022-01-01', '2023-01-01'),
(2, '2021-06-01', '2023-06-01'),
(3, '2020-05-15', '2021-05-15'),
(4, '2019-03-10', '2022-03-10'),
(4, '2023-06-01', '2024-06-01'),
(4, '2022-09-01', '2023-02-01'),
(5, '2018-01-01', '2026-01-01'),
(5, '2020-10-10', '2020-11-10'),
(1, '2021-01-01', '2021-12-31'),
(3, '2023-07-01', '2024-01-01');

-- Призначення працівників
INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
(1, 1), (1, 2), (1, 3),
(2, 2), (2, 3), (2, 4),
(3, 5), (3, 6),
(4, 1), (4, 4), (4, 7), (4, 8),
(5, 9), (5, 10), (5, 1),
(6, 2),
(7, 3), (7, 4),
(8, 5), (8, 6), (8, 7),
(9, 8), (9, 9), (9, 10), (9, 2), (9, 3),
(10, 1), (10, 4), (10, 5);