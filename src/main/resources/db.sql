

delete from roles;
delete from users;

INSERT INTO users (id,dob,email,name,password) VALUES 
 (1,NULL,'ba.bessem@gmaill.com','Admin','admin'),
 (2,NULL,'ba.bessem@yahoo.com','Pirana','aka');

INSERT INTO roles (role_id,role_name,user_id) VALUES 
 (1,'ROLE_ADMIN',1),
 (2,'ROLE_USER',1),
 (3,'ROLE_USER',2);
