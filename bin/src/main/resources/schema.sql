CREATE TABLE tournament(
  id INT PRIMARY KEY,
  reward_amount INT,
);

CREATE TABLE player(
	id INT PRIMARY KEY,
	name VARCHAR,
	tournament_id INT
);