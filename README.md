アナウンス2022/12/05
table構造をいじったので、setup.sqlを実行して下さい。(passwordは最下部参照)
部署毎に勤怠状況一覧を作ってほしい(勘違いしてたが、中島くんにやってもらったのは3.1.2でした。3.1.5をやっていってもらうおう)

## dataBase構造

### users table(ユーザーテーブル)
id INTEGER NOT NULL,
name TEXT,
password TEXT NOT NULL,
auth TEXT,
division_id INTEGER

### attendances table(勤怠テーブル)
id INTEGER NOT NULL,
user_id INTEGER,
date DATE,
begin_time TIME,
end_time TIME, 
rest_start_time TIME,
rest_end_time TIME,
work_place_id INTEGER,
primary key(id));



### master_work_places table(勤務場所マスタテーブル)
id(integer)
name(text)

### divisions table(部署テーブル)
id(integer)
name(text)


## 担当
### 中島俊介
ログイン画面 CSS
勤怠入力


## 実行方法
host環境(多くの人はwindowsだと思います)にpostgre環境を用意して、
上述のtable構造(attendances tableなど)を作ることで、動作します。
setup.sqlを実行。


## ログイン ROLE_USER
[name => user1, password => password1]
[name => user2, password => password2]
[name => user3, password => password3]
で入れる。

## ログイン ROLE_ADMIN
[name => admin1, password => password1]
[name => admin2, spassword => password2]
で入れる。

## ログインは   を参考にした。