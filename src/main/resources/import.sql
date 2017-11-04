INSERT INTO buglava.project (id, name) VALUES (1,'WebProject');
INSERT INTO buglava.project (id, name) VALUES (2,'ClientProject');
INSERT INTO buglava.project (id, name) VALUES (3,'ServerProject');
INSERT INTO buglava.task (id, project_id, name, type, status, priority, description) VALUES (1, 1, 'Task1', 0, 1, 0, 'description1');
INSERT INTO buglava.task (id, project_id, name, type, status, priority, description) VALUES (2, 1, 'Task1.1', 0, 1, 0, 'description1.1');
INSERT INTO buglava.task (id, project_id, name, type, status, priority, description) VALUES (3, 2, 'Task2', 1, 2, 2, 'description2');
INSERT INTO buglava.task (id, project_id, name, type, status, priority, description) VALUES (4, 2, 'Task3', 1, 2, 3, 'description2');
INSERT INTO buglava.task (id, project_id, name, type, status, priority, description) VALUES (5, 2, 'Task3.3', 1, 2, 3, 'description2.2');