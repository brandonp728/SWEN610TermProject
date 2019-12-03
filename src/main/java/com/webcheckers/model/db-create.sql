DROP TABLE IF EXISTS PLAYER CASCADE;
DROP TABLE IF EXISTS ACCOUNT CASCADE;
DROP TABLE IF EXISTS GAME CASCADE;
DROP TABLE IF EXISTS TOURNAMENT CASCADE;

CREATE TABLE PLAYER (
    player_id SERIAL PRIMARY KEY,
    f_name text,
    l_name text,
    is_computer boolean,
    games_won int,
    games_lost int
);

CREATE TABLE ACCOUNT (
    account_id SERIAL PRIMARY KEY,
    username text,
    pwd_hash text,
    player_id int REFERENCES PLAYER(player_id)
);

CREATE TABLE TOURNAMENT(
    tournament_id SERIAL PRIMARY KEY,
    tournament_timestamp timestamp,
    num_players int,
    num_games int,
    winner_id int REFERENCES PLAYER(player_id) 
);

CREATE TABLE GAME (
    game_id SERIAL PRIMARY KEY,
    elapsed_time timestamp,
    game_timestamp timestamp,
    player1_id int REFERENCES PLAYER(player_id),
    player2_id int REFERENCES PLAYER(player_id),
    winner_id int REFERENCES PLAYER(player_id),
    tournament_id int REFERENCES TOURNAMENT(tournament_id)
);