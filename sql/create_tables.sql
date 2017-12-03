DROP TABLE IF EXISTS `transaction`;
DROP TABLE IF EXISTS `budgetedItem`;
DROP TABLE IF EXISTS `subCategory`;
DROP TABLE IF EXISTS `category`;
DROP TABLE IF EXISTS `income`;
DROP TABLE IF EXISTS `budgetMonth`;
DROP TABLE IF EXISTS `user_role`;
DROP TABLE IF EXISTS `users`;

create table users (
     account_id      int(11) NOT NULL auto_increment,
     user_name       varchar(15) NOT NULL,
     user_pass       varchar(15) NOT NULL,
     first_name      varchar(25),
     last_name       varchar(30),
     email_address   varchar(60),
     PRIMARY KEY  (account_id)
);
CREATE UNIQUE INDEX users_user_name_uindex ON users (user_name);

create table user_role (
     user_role_id    int(11) NOT NULL auto_increment,
     user_name       varchar(15) NOT NULL,
     roll_name       varchar(15) NOT NULL,
     PRIMARY KEY (user_role_id),
     FOREIGN KEY fk_users(user_name)
     REFERENCES users(user_name)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);


create table budgetMonth (
     budget_month_id    int(11) NOT NULL AUTO_INCREMENT,
     budget_date        DATE NOT NULL,
     account_id         int(11) NOT NULL,
     PRIMARY KEY (budget_month_id),
     FOREIGN KEY fk_users(account_id)
     REFERENCES users(account_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);


create table income (
     income_id         int(11) NOT NULL AUTO_INCREMENT,
     pay_date          DATE,
     pay_amount        DECIMAL(7,2) NOT NULL,
     budget_month_id   int(11) NOT NULL,
     PRIMARY KEY (income_id),
     FOREIGN KEY fk_budgetMonth(budget_month_id)
     REFERENCES budgetMonth(budget_month_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);


create table category (
     category_id      int(11) NOT NULL AUTO_INCREMENT,
     category_name    varchar(60) NOT NULL,
     budget_month_id  int(11) NOT NULL,
     PRIMARY KEY (category_id),
     FOREIGN KEY fk_budgetMonth(budget_month_id)
     REFERENCES budgetMonth(budget_month_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);


create table budgetedItem (
     budgeted_id      int(11) NOT NULL AUTO_INCREMENT,
     subCategory_name varchar(60) NOT NULL,
     budgeted_amount  DECIMAL(7,2),
     due_date         DATE,
     envelope_amount  DECIMAL(7,2),
     note             TEXT,
     category_id      int(11) NOT NULL,
     PRIMARY KEY (budgeted_id),
     FOREIGN KEY fk_category(category_id)
     REFERENCES category(category_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);

create table transaction (
     transaction_id     int(11) NOT NULL AUTO_INCREMENT,
     transaction_amount DECIMAL(7,2),
     transaction_date   DATE,
     note               TEXT,
     budgeted_id        int(11) NOT NULL,
     PRIMARY KEY (transaction_id),
     FOREIGN KEY fk_budgetedSubCategory(budgeted_id)
     REFERENCES budgetedItem(budgeted_id)
          ON DELETE CASCADE
          ON UPDATE CASCADE
);



