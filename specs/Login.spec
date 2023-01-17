LOGIN TEST
=====================
Created by abaltaci on 17.04.2022

This is an executable specification file which follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.
     
## Uygulamaya basarili olarak login ol
tags: Login

* Uygulamayi ac
* Login Butonuna tikla
* Kullanici adi ve sifre bilgisini gir
|EMAIL                   |PASSWORD    |
|------------------------|------------|
|vojexo2542@unicsite.com |S123456*    |
*Basarili olarak login oldugunu dogrula



## Kullanci adi dogru - sifre hatali login
tags: Login

* Uygulamaya email ve sifre ile login ol ve "EMAIL_OR_MAIL_INCORRECT" hata mesajini dogrula
|EMAIL                   |PASSWORD    |
|------------------------|------------|
|vojexo2542@unicsite.com |S123456     |



## Kullanci adi yanlis - sifre dogru login
tags: Login

* Uygulamaya email ve sifre ile login ol ve "EMAIL_OR_MAIL_INCORRECT" hata mesajini dogrula
|EMAIL                   |PASSWORD    |
|------------------------|------------|
|voje2542@unicsite.com   |S123456*    |



## Kullanci adi hatali - sifre hatali login
tags: Login

* Uygulamaya email ve sifre ile login ol ve "EMAIL_OR_MAIL_INCORRECT" hata mesajini dogrula
|EMAIL                   |PASSWORD    |
|------------------------|------------|
|vo2542@unicsite.com     |123456      |
