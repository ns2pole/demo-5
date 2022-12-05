## dataBase構造
### attendances table
id(integer),
user_id(integer),
date(date),
begin_time(time without time zone),
end_time(time without time zone),
rest(integer)

### user table(修正する予定)
 id       | integer |           |          | 
 username | text    |           |          | 
 password | text    |           |          | 
 user_id  | text    |   
 auth     | text    |   

## 担当
### 中島俊介
ログイン画面 CSS
勤怠入力


## 実行方法
host環境(多くの人はwindowsだと思います)にpostgre環境を用意して、
上述のtable構造(attendances tableなど)を作ることで、動作します。
users_tableには「username =>'user',password => '$2a$08$Skj/R3IthjGG0P7KDJ/S3eaWXFGD9ioxpL44kpD7Tq5Gl5yaBPDfq'」というデータを追加して下さい。

※postgresでselectを行うと下記のようになるように。
postgres=# SELECT * FROM users;
 id | username |                           password                           | user_id |    auth    
----+----------+--------------------------------------------------------------+---------+------------
  1 | user     | $2a$08$Skj/R3IthjGG0P7KDJ/S3eaWXFGD9ioxpL44kpD7Tq5Gl5yaBPDfq | 1       | ROLE_USER
  2 | admin    | $2a$08$Skj/R3IthjGG0P7KDJ/S3eaWXFGD9ioxpL44kpD7Tq5Gl5yaBPDfq | 2       | ROLE_ADMIN
(2 rows)



## ログイン ROLE_USER
[username => user,password => password]で入れる。
## ログイン ROLE_ADMIN
[username => admin,password => password]で入れる。

## ログインは https://itmaroblog.com/webapplication-java-spring_8/を参考にした。