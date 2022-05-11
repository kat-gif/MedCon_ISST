


insert into users(username, password, enabled) values ('admin', 
    '{bcrypt}$2a$04$Q5mbauI04K9u2gSoE3g.cud8SBUUa/5N0btc2CAkpdrzK0cukqkLO', true); /*password:admin*/ 
insert into authorities(username, authority) values ('admin', 'ROLE_ADMIN');

