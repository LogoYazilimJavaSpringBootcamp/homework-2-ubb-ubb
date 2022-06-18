## HOMEWORK - 2

***• Java dünyasındaki framework’ler ve çözdükleri problemler nedir?(Spring MVC, JSP,Struct, Vaadin). Örnekler ile
açıklayın. (20 Puan)***

Spring MVC: Web uygulamaları build etmek için kullanılır. Model-View-Controller design patternini kullanır. Loosely
couple ve flexible uygulamalar hazırlamaya yardımcı olur. Spring core frameworkündeki tüm temel özellikleri kullanır (
IoC, DI). Model, uygulamanın verisini tutar. Veri tek bir obje ya da veri koleksiyonu olabilir Genellikle POJO'ları
içerir. Controller, uygulamanın logicini tutar. @Controller anotasyonu ile sınıflar işaretlenebilir. View, bilginin
istenen formatta yansıtılmasıdır. Genelde JSP+JSTL kullanılır.

JSP: Java Server Pages dinamik, platform bağımsız web uygulamaları yaratmaya yarayan server tarafı bir programlama
teknolojisidir. JSP ile sayfa hazırlamak genellikle hızlı ve kolaydır. Java servletleri ile sorunsuz bir şekilde
etkileşir.

Struts: MVC bazlı web aplikasyonları kurmak için kullanılan bir frameworktür. Programlamacılara esnek, bakımı kolay ve
güvenli aplikasyonlar yazmasına yardımcı olur. Her komponent uygulamanın farklı oluşumundan sorumludur. Apache
tarafından geliştirilmiştir. Java Servlet yapısını inherit eder. Konfigürasyonlar için XML yapısı kullanır. Tema
desteği, POJO tabanlı aksiyonlar, konfigüre edilebilir componentler, tag ve entegrasyon desteği sağlar.

Vaadin: Açık kaynak kodlu web uygulama geliştirme platformudur. GUI'yi sadece Java ve TypeScriptle geliştirmeye olanak
sağlar. Bu sebeple sırf Java ile programlama yapabilen geliştiriciler için kolaylık sağlamaktadır. UI komponentlerini
dokümantasyonda yazıldığı şekilde kolayca sayfaya eklenebilir.

Hibernate: Hibernate database ile olan etkileşimi basitleştiren bir frameworktür. Açık kaynak kodlu, lightweid ve ORM
aracıdır. JPA özelliklerini implement etmiştir. Persistance logic geliştirmemizi sağlar. Persistence logic geliştirmek
için Objeleri kullanır.

Blade: Full-stack MVC web uygulama frameworküdür. Açık kaynak kodlu ve lightweight tir. Kullanıcı dostudur. Syntax
kullanımı kolaydır.

Google Web Toolkit: GWT, Google tarafından geliştirilmiş web uygulama frameworküdür. Client tarafı java yazmamıza olanak
tanır. JavaScript olarak browsera deploy eder. Gwt ile front end teknolojilerinde uzman olmadan güzel JavaScript
optimizasyonu ve responsive tasarım yapmamıza olanak sağlar.

***• Katmanlı mimari nedir? (10 Puan)***

Katmanlı mimari, en popüler yazılım mimarilerden bir tanesidir. Katmanlı mimaride birbirine benzeyen modüller veya
component'ler gruplandırılarak aynı katmanda tutulur. Her katman spesifik görevi yerine getirir. Ayrıca n-tier
architecture olarak da bilinir. Katman mimarisi katman sayısı konusunda kısıtlama getirmez. İsimlendirme herhangi bir
tanım olabilir ancak genelde presentation layer, business layer ve physical layer bulunur. Katmanlar arası bağlantı,
method çağrısı, database sorgusu, obje veya çağrı ileten herhangi bir yapı olabilir.

Presentation layer son kullanıcıya gösterilecek tüm GUI/interface sınıf ve metodlarını tutar. Ideal olarak son
kullanıcının kullanacağı layer olarak gruplandırılmalıdır.

Business/logic layer uygulamanın fonksiyonlarının yerine getirmesi için tüm logici tutar. Data bütünleştirme, hesaplama
ve sorgu işlemleri bu layerda yapılır. Ana logic burda ifade edilir.

Data/Persistence Layer bilginin depolandığı layerdır. Bu katman hem logical yapıların hem de somut verilerin tutulduğu
yerdir.

Connectorlar genellikle 2 layer arasında çalışır.
Bağlantı genellikle 2 layer arasında olur.
Veri iki yönlü çalışır.

Open Layer: Bir üstteki katmanın, bir alttaki katmana, kendisini bypass ederek geçtiği layerdır.

Closed Layer: Bir üstündeki katmanın bir alttaki katmana, kendisini bypass etmeden geçemediği layerdır.

Sinkhole: Bulunan katman herhangi bir işlevi yerine getirmiyorsa bu katmana sinkhole denir.

Örnek katmanlı yapı mimarisi diyagramı:

![Ornek](https://i.ibb.co/bg9HLSj/la-drawio.png)

***• Garbage collector nedir, nasıl çalışır? Diğer C++ ile karşılaştırın. (10 Puan)***

Garbage Collection, Java'nın otomatik hafıza yönetme işlemidir. Garbage collection kullanılmayan objeleri bulma ve silme
işlemi yapar. Tüm objeleri tek tek heap'te izleyerek kullanılmayan objeleri siler. GC implementasyonu JVM içerisinde yer
alır.

GC temel olarak 2 adımda işlemlerini gerçekleştirir.

Mark: GC, hangi objelerin memory'de kullanılıp kullanılmadığını işaretler.

Sweep: Mark adımında işaretlenen objeleri kaldırır.

Avantajları, manuel memory allocation/deallcoation yapma zorunluğunu kaldırmasıdır. Pointer kullanım kontrolü yapmamıza
gerek kalmaz. Otomatik Memory leak kontrolü sağlar.

Dezavantajları ise, JVM tüm objeleri takip edeceği için CPU kullanımını arttırmaktadır. Bazı GC implemantasyonları
uygulamayı beklenmedik şekilde durdurabilir.

High-level diller standart olarak GC implemantasyonlarına sahip olmaya yatkındır. Bazı dillerde built-in olarak GC
bulunmaz ancak kütüphaneler(Boehm Garbage Collector) ile eklenebilir(C, C++). Çoğu fonksiyonel programlama dilleri, ML,
Haskell, APL builtin GC'ye sahiptirler. Lisp ise hem ilk fonksiyonel programlama dili olması ile hem de ilk olarak GC'yi
sunması nedeniyle dikkat çekmektedir.

C++'de built in garbage collector yoktur. Ancak Boehm-Weiser kütüphanesi ile GC kullanılabilir.

Kütüphane olmadan C++ memory yönetimini manuel olarak yapar. Memory'yi kolay şekilde allocate - deallocate edebiliriz.
Allocation ve deallocation için new ve delete operatorleri kullanılır.

***• Spring frameworkünün kullandığı design patternlar neler? (10 Puan)***

- IoC or DI: Dependency'yi düşürür. Loosely copule, programlar yazmamıza yardımcı olur.
- Proxy Pattern: Bir nesnenin(proxy)  başka bir nesneyi (client ya da servis)  kontrol etmesine izin verir.
- Singleton Pattern: Objenin tek bir instance'ının tüm uygulamada kullanılmasını sağlar.
- Prototype Pattern: Objelerin mevcut bulunan objeden kopyalanarak oluşturulmasını sağlar.
- Factory Pattern: İstenen nesneyi oluşturmak için soyut bir methodla fabrika sınıfını çağırır.
- Template Pattern: Algoritmayı operasyonun temeli olarak tanımlar ve implement edilecek ayrıntıları alt sınıflarda
  uygulanacak şekilde bırakır.
- MVC Pattern: Model-View-Control componentlerini birbirininden ayırır.

***• Creational Patterns neler? Önceki ödevde oluşturulan nesnelerinizi Factory Design patterni ile oluşacak şekilde
düzenleyin. (25 Puan)***

- Factory Method: Bir üst sınıfta nesneler oluşturmak için bir arabirim sağlayan, ancak alt sınıfların oluşturulacak
  nesneleri değiştirmesine izin verir.
- AbstractFactory: Aynı grupta olan objeleri concrete classlarda tanımlamadan yaratmamızı sağlar.
- Builder: Kompleks objeleri adım adım yaratmamızı sağlar.
- Prototype: Mevcut objeleri kopyalayarak yeni objeler oluşturmamızı sağlar.
- Singleton: Bir sınıfın sadece bir instance olmasını sağlar.

---
Bir önceki ödevde oluşturulan objeler Factory Method design patternine uygun olacak şekilde düzenlendi.

Inheritance sadece Supplier, Customer ve Company sınıflarında olduğu için sadece bu sınıflar için FactoryMethod implement edildi.
Önceki ödevde şirketler Servis sınıfında bulunan create methodu ile oluşturulmuştu ancak bu ödevde CompanyFactory sınıfı
ile oluşturulmaktadır.


```
public abstract class Company {...}  
```

```
public class Customer extends Company implements Comparable {...}
```

```
public class Supplier extends Company implements Comparable {...}
```

```
public class CompanyFactory {
    /**
     * 
     * @param str, SUPPLIER or CUSTOMER
     * @param name , company name
     * @param sector, company sector
     * @return Company, supplier object or customer object.
     */
    public Company getType(String str, String name, String sector) {

        if (str.equalsIgnoreCase("SUPPLIER")) {
            return new Supplier(name,sector);
        }
        else if (str.equalsIgnoreCase("CUSTOMER")) {
            return new Customer(name,sector);
        }
        else {
            return null;
        }
    }
```

```
        // Creating new Companies with Factory Method
        CompanyFactory company = new CompanyFactory();
        Company company1 = company.getType("CUSTOMER", "Vestel", "Electronics");
        Company company2 = company.getType("CUSTOMER", "Bauhaus" , "Wood works");
        Company company3 = company.getType("CUSTOMER", "Arcelik" , "Electronics");
        Company company4 = company.getType("CUSTOMER", "IKEA" , "Wood works");
        Company company5 = company.getType("CUSTOMER", "Enka" , "Construction");
        Company company6 = company.getType("SUPPLIER", "Hilti", "Tools");
        Company company7 = company.getType("SUPPLIER", "Hafele" , "Hardware");
        Company company8 = company.getType("SUPPLIER", "Bauhaus" , "Wood works");
        Company company9 = company.getType("SUPPLIER", "Amazon" , "Books");
```

***• Singleton ve AbstractFactory patterlerini implemente eden kodu yazın.(25 Puan)***

[SingletonAbstractFactory](/SingletonAbstractFactory) klasöründe inceleyebilirsiniz.




