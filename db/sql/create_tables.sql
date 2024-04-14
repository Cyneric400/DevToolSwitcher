DROP TABLE IF EXISTS Projects;
DROP TABLE IF EXISTS Runs;
DROP TABLE IF EXISTS Commands;

CREATE TABLE Projects(
	id INT,
	name VARCHAR(100),
    description VARCHAR (255),
	PRIMARY KEY (id)
);

CREATE TABLE Runs(
	project_id INT,
	cmd_id INT,
	PRIMARY KEY (project_id, cmd_id),
	FOREIGN KEY (project_id) REFERENCES Projects,
	FOREIGN KEY (cmd_id) REFERENCES Commands
);

CREATE TABLE Commands(
	cmd_id INT,
	cmd_text VARCHAR(1000),
	PRIMARY KEY (cmd_id)
);