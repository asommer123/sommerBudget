create table users (
     account_id      int(11) NOT NULL auto_increment,
     user_name       varchar(25) NOT NULL,
     first_name      varchar(25),
     last_name       varchar(30),
     email_address   varchar(60),
     PRIMARY KEY  (account_id)
);


create table budgetMonth (
     budget_month_id    int(11) NOT NULL AUTO_INCREMENT,
     budet_date         DATE NOT NULL,
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
     PRIMARY KEY income_id,
     FOREIGN KEY fk_budgetMonth(budget_month_id)
     REFERENCES budgetMonth(budget_month_id)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);


create table category (
     category_id      int(11) NOT NULL AUTO_INCREMENT,
     category_name    varchar(60) NOT NULL,
     account_id       int(11),
     PRIMARY KEY (category_id),
     FOREIGN KEY fk_account(account_id)
     REFERENCES users(account_id)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

create table subCategory (
     subCategory_id   int(11) NOT NULL AUTO_INCREMENT,
     subCategory_name varchar(60) NOT NULL,
     budget_amount    decimal(7,2),
     due_date         DATE,
     envelope_amount  DECIMAL(7,2),
     note             TEXT,
     category_id      int(11),
     budget_month_id  int(11),
     PRIMARY KEY (subCategory_id),
     FOREIGN KEY fk_category(category_id)
     REFERENCES category(category_id),
     FOREIGN KEY fk_budetMonth(budget_month_id)
     REFERENCES budgetMonth(budget_month_id)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);

create table transaction (
     transaction_id     int(11) NOT NULL AUTO_INCREMENT,
     transaction_amount DECIMAL(7,2),
     transaction_date   DATE,
     note               TEXT,
     subCategory_id     int(11),
     PRIMARY KEY (transaction_id),
     FOREIGN KEY fk_subCategory(subCategory_id)
     REFERENCES subCategory(subCategory_id)
     ON DELETE CASCADE
     ON UPDATE CASCADE
);












