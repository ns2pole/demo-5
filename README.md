中島くんへ
セキュリティの関係で、このリポジトリをprivateに設定しました。

## dataBase構造
### attendances table

id(integer),
date(date),
begin_time(time without time zone),
end_time(time without time zone),
rest(integer)


### user table(修正する予定)
 id       | integer |           |          | 
 username | text    |           |          | 
 password | text    |           |          | 
 user_id  | text    |   

## 担当
### 中島俊介
ログイン画面 CSS


## 実行方法
host環境(多くの人はwindowsだと思います)にpostgre環境を用意して、
上述のtable構造(attendances tableなど)を作ることで、動作します。

## ログイン
[username => user,password => password]で入れる。