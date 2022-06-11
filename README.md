# search-text

Proje ile aynı dizinde ekli olan RequiredFiles.zip dosyası zipten çıkarılır. 
RequiredFiles dosyası içerisindeki dosyaları(poc,Gauge) dışarıda bir yerde konumlandırabilirsiniz. 
Örneğin : C dizini altına veya workspace folder'ı altına taşınabilir.

Gauge folder'ı gauge framework'un exe,plugin,config dosyalarını içeriyor. Bilgisayarınızda Gauge'i aktif hale getirmek için ortam değişkenlerinden
Gauge folder'ının path'ini vermeniz gerekiyor. Örneğin: GAUGE_HOME = C:\\Gauge gibi. 

Tanımlamayı yaptıktan sonra Komut İşlemi ekranında "gauge -v" yazınız. Aşağıdaki ekran görüntüsünde belirtilen bilgilerin dönmesi gerekmektedir.

![image](https://user-images.githubusercontent.com/104354928/165692354-fd9b7d20-24a7-4bf1-9a3f-89b8e706ef7f.png)

Tanımlamalar bittikten sonra projenin olduğu dizine giderek. "gauge init java" komutunu çalıştırıız. 

poc klasöründe ise iki alt klasör bulunuyor bunlar :

webdriver -> chromedrvier.exe dosyası bulunuyor. Chrome 99 versiyonu için eklidir. 
             Browser versiyonunuz farklı ise browserınıza uygun chromedriver.exe dosyasını klasörün altına ekleyebilirsiniz.  
dataFiles -> searchText.txt ve urlList.csv dosyaları bulunuyor.
    searchText.txt -> Web sayfası içerisinde arancak kelimeler bu txt dosyasından okunuyor. Aramak istediğiniz kelime ve/veya kelimeleri bu txt içerisine yazabilirsiniz.
    urlList.csv -> Hangi web sitesinde ve/veya alt sayfalarında islme yapılacak ise url bilgisi bu csv dosyasına yazılıyor.


run command -> mvn gauge:execute -Dflags=--max-retries-count=2 -DspecsDir=specs -DinParallel=true -Denv=Default -Dnodes=5 -Dtags="SearchText"
