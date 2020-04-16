# newemployee_android_7
画面遷移とIntentクラス

## 画面遷移

### 画面遷移元
```
//引数を渡す
intent.putExtra("menuName", menuName)
intent.putExtra("menuPrice", menuPrice)

startActivity(intent)
```

### 画面遷移先
```
//引数を受け取る
val menuName = intent.getStringExtra("menuName")
val menuPrice = intent.getStringExtra("menuPrice")
```

```
//画面を閉じる
finish()
```
