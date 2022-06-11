# Homework-1

**1. Java’nın platform bağımsızlığını nasıl sağladığını anlatınız.(5 PUAN)**

Platform bağımsızlığı, bir yazılımın özel bir sisteme bağlı kalmadan çalışabilmesidir. Java, platform bağımsız olarak çalışmaktadır. 

- Kaynak kodu java olan bir program ilk önce javac tarafından derlenir. 
- Java compilerdan oluşan dosya .class (byte code) olarak çıktı verir. 
- Oluşan byte-code makine dili değildir. Okunması için interpreter'e ihtiyaç duyar. 
- JVM(Java Virtual Machine) byte-codu makine diline çevirir. Makine diline çevrilen kod çalıştırılarak istenen çıktıyı vermektedir. 
- JVM, her byte-codunu hangi platformda olursa olsun, makine diline çevirebilir. Bu sebeple Java'ya platform bağımsızlığını sağlamaktadır.

Ancak JVM kurulumu her platform için farklıdır. Bu sebeple JVM platform bağımlısıdır.


**2. Java neden çoklu kalıtımı desteklemez? Hangi diller bu duruma neden izin verir? (5 PUAN)** 

Java'nın çoklu kalıtıma izin vermeme sebebi ikili anlam belirsizliğinin önüne geçmektir. Bu belirsizliğe en büyük örnek diamond problemidir. Aşağıda örnek UML diyagramından görüleceği üzere Class A'da methodA tanımlanmış ve Class B ve Class C de methodA override edilmiştir. Class D'nin B ve C nin çocukları olduğu durumda methodA'nın hangi sınıfın methodunu kullanacağı belirsizdir. 

<p align="center">
  <img src="https://i.ibb.co/N97tG2B/ubb2.png" alt="UML Diagram for Diamond Problem"/>
</p>

Java Lead Designer James Gosling, diğer dillerde bulunan, çoklu kalıtımla ilgili sorunların ortadan kaldırmanın, Java'nın yaratılmasındaki motivasyonlardan biri olduğunu belirtmiştir.  

Çoklu kalıtımı destekleyen diller: C++, Python, Common Lisp, EuLisp, Curl, Dylan, Eiffel, Logtalk, Object REXX, Scala, OCaml, Perl, POP-11, R, Raku, ve Tcl'dir.  

Bu dillerin çoklu kalıtıma izin vermesinin sebebi ise, programcılara aynı anda birden fazla dikey hiyerarşi kullanmasına izin vermesidir. Örnek olarak, Cat sınıfının Cartoon, Pet ve Mammal sınıflarından inherit edilmesine ve tüm bu sınıfların özelliklerine erişmesine izin vermektedir.

**3. Build Tool nedir? Java ekosistemindeki toollar neler?**  

Build Tool, kaynak koddan yürütülebilir uygulamaların oluşturulmasını otomatikleştiren programlardır.  

Bağımlılıkları ayarlamak, kaynak kodunu makina koduna çevirmek, paketleme, test koşturma gibi konularda programlamacılara kolaylık sağlar.

Küçük projelerde, geliştiriciler genellikle oluşturma sürecini manuel olarak hazırlar. Daha büyük projelerde ise, bağımlılıkları ayarlamak, neyin ve hangi sırayla build edilmesinin gerekliliğini takip etmek çok zor olduğu için manuel hazırlık pratik değildir. Build tool kullanmak, proje oluşturma sürecinin daha tutarlı ve stabil olmasını sağlar.

Java ekosisteminde bulunan popüler bazı build toollar: Maven, Gradle, Ant, Jenkins, Bazel.

**4. Collection framework içerisindeki yapıları örnekleyip açıklayınız. (20 PUAN)**  

Collection framework içerisinde bulunan veri yapıları;
- List: Collection interface'inden inherit eden bir interfacedir. List özellikleri barındırır. 
  - ArrayList: Büyüklüğü dinamiktir. Array veri yapısıdır.
  - LinkedList: Büyüklüğü dinamiktir. Veri yapısında verinin kendisi ile beraber bir sonraki veriyi gösteren pointer tutulur.
  - Vector: Büyüklüğü dinamik array yapısıdır. Çoklu yürütme sırasında senkronize olarak çalışır. 
  - Stack: LIFO (Last In First Out) prensibi ile çalışan bir veri yapısıdır.Push, pop operasyonları gerçekleştirilebillir.
- Queue: Collection interface'inden inherit eden FIFO (First In First Out) prensibine dayanan bir interfacedir.
  - PriorityQueue: Önceliklendirme bazlı FIFO prensibine sahip veri yapısıdır.
  - ArrayDeque: Queuenin başına ve sonuna ekleme ve çıkarma imkanı verir.
- Set: Elementlerin sırasız ve benzersiz şekilde şekilde tutulduğu arabirimdir.
  - HashSet: Objelerin benzersiz şekilde tutulduğu veri yapısıdır.
  - LinkedHashSet: HashSet veri yapısının sıralı bir şekilde tutulduğu doubly-linked-list veri yapısıdır. 
  - TreeSet: Elementlerin sırayla tutulduğu veri yapısıdır. compareTo override edilerek sıralama ölçütü ayarlanabilir.
- Map: Key,Value anahtar değer yapısına sahip veri yapısıdır. Dict özelliklerini taşır.
  - TreeMap: Key value sıralı şekilde verileri tutar. compareTo override edilerek sıralama ölçütü ayarlanabilir.
  - HashMap: Map interface'inin temel implementasyonudur. Rastgele memory'de yer tutar.
  - HashTable: HashMap'ten farkı senkronize olmasıdır. Null değer almaz.
  - LinkedHashMap: HashMap özelliklerine ek olarak, ekleme sırasına göre verileri tutar.

**5. Uygulama**

Uygulama amacı, kullanacak olan müşterinin, sipariş oluşturması, sipariş sonucu oluşan faturayı sisteme kaydedebilmesi ve siparişleri görüntüleyebilmesidir.
Uygulama için istenen, Maven build tool ile oluşturulması, main metodda çalışması ve çeşitli filtrelemeleri sağlayabilmesidir.

Maven Build Lifecycle Komutları  
clean: Maven tarafından oluşturulan tüm dosyalar ve klasörleri siler. 
```
mvn clean
```

```
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ AccountingSystem ---
[INFO] Deleting /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/target
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.269 s
[INFO] Finished at: 2022-06-11T02:11:53+03:00
[INFO] ------------------------------------------------------------------------
```

validate: Projenin doğruluğunu kontrol eder. Gerekli bilgilerin sağlandığını teyit eder.  
```
mvn validate
```

```
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  0.178 s
[INFO] Finished at: 2022-06-11T02:17:12+03:00
[INFO] ------------------------------------------------------------------------
```

compile: Proje kaynak kodlarını derler.  
```
mvn compile
```
```
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ AccountingSystem ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 7 source files to /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/target/classes
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  2.641 s
[INFO] Finished at: 2022-06-11T02:20:01+03:00
[INFO] ------------------------------------------------------------------------
```

test: Projede derlenen kaynak kodlarını, uygun test frameworkleri ile koşturur. 
```
mvn test
```
```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ AccountingSystem ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ AccountingSystem ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ AccountingSystem ---
[INFO] No tests to run.
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.115 s
[INFO] Finished at: 2022-06-11T02:22:35+03:00
[INFO] ------------------------------------------------------------------------
```

package: Derlenen kodu paketler, örnek JAR formatı.
```
mvn package
```
```
[INFO] Scanning for projects...
[INFO]
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ AccountingSystem ---
[INFO] Nothing to compile - all classes are up to date
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ AccountingSystem ---
[INFO] No sources to compile
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ AccountingSystem ---
[INFO] No tests to run.
[INFO]
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ AccountingSystem ---
[INFO] Building jar: /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/target/AccountingSystem-1.0-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.847 s
[INFO] Finished at: 2022-06-11T02:24:07+03:00
[INFO] ------------------------------------------------------------------------
```

verify: Entegrasyon testleri ile geçerleme yapar.
```
mvn verify
```
```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ AccountingSystem ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ AccountingSystem ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ AccountingSystem ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ AccountingSystem ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.809 s
[INFO] Finished at: 2022-06-11T02:25:59+03:00
[INFO] ------------------------------------------------------------------------
```
install: Oluşturulan paketi lokal repoya aktarır.
```
mvn install
```
```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ AccountingSystem ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ AccountingSystem ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ AccountingSystem ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ AccountingSystem ---
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ AccountingSystem ---
[INFO] Installing /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/target/AccountingSystem-1.0-SNAPSHOT.jar to /home/ubb-gyb/.m2/repository/org/example/AccountingSystem/1.0-SNAPSHOT/AccountingSystem-1.0-SNAPSHOT.jar
[INFO] Installing /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/pom.xml to /home/ubb-gyb/.m2/repository/org/example/AccountingSystem/1.0-SNAPSHOT/AccountingSystem-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.930 s
[INFO] Finished at: 2022-06-11T02:27:55+03:00
[INFO] ------------------------------------------------------------------------
```

deploy: Final paketi remote repository'ye kopyalar.
```
mvn deploy
```
```
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------< org.example:AccountingSystem >--------------------
[INFO] Building AccountingSystem 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/main/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ AccountingSystem ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ AccountingSystem ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ AccountingSystem ---
[INFO] No sources to compile
[INFO] 
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ AccountingSystem ---
[INFO] No tests to run.
[INFO] 
[INFO] --- maven-jar-plugin:3.2.2:jar (default-jar) @ AccountingSystem ---
[INFO] 
[INFO] --- maven-install-plugin:2.4:install (default-install) @ AccountingSystem ---
[INFO] Installing /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/target/AccountingSystem-1.0-SNAPSHOT.jar to /home/ubb-gyb/.m2/repository/org/example/AccountingSystem/1.0-SNAPSHOT/AccountingSystem-1.0-SNAPSHOT.jar
[INFO] Installing /home/ubb-gyb/Swe/05-bootcamp/homework-1-ubb-ubb/pom.xml to /home/ubb-gyb/.m2/repository/org/example/AccountingSystem/1.0-SNAPSHOT/AccountingSystem-1.0-SNAPSHOT.pom
[INFO] 
[INFO] --- maven-deploy-plugin:2.7:deploy (default-deploy) @ AccountingSystem ---
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.901 s
[INFO] Finished at: 2022-06-11T02:31:04+03:00
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-deploy-plugin:2.7:deploy (default-deploy) on project AccountingSystem: Deployment failed: repository element was not specified in the POM inside distributionManagement element or in -DaltDeploymentRepository=id::layout::url parameter -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```





Lombok plugini kullanabilmek için pom.xml dosyasına dependency eklenmiştir.
```
 <dependency>
      <groupId>org.projectlombok</groupId>
      <artifactId>lombok</artifactId>
      <version>1.18.24</version>
      <scope>provided</scope>
 </dependency>
```

Proje UML diagramı:  

<p align="center">
  <img src="https://i.ibb.co/4WrcJkN/package.png" alt="UML Diagram for Diamond Problem"/>
</p>

İsterler için çalıştırılması gereken örnek kodlar aşağıdadır.

Tüm müşterileri listelemek için:  
```user.listAllCustomer();```
```
List of all customers:
0 Enka
1 Otokoc
2 Isdemir
3 Arcelik
4 IKEA
5 Casa
```

Yeni müşteri oluşturabilmek için:  
```user.createNewCustomer("Enka", "Construction");```


Müşterileri harfe göre sıralayabilmek için:  
```user.listCustomerByLetter("C");```
```
List of customers that contains letter: C
1 Otokoc
3 Arcelik
5 Casa
```

Fatura toplam tutarını firmanin kayıt olduğu aya göre sıralamak için:  
```user.listInvoiceByCustomerMonth(5);```
```
List of total invoice amount for customers that are registered in month: JUNE
Enka 5300.0
Otokoc 0.0
Isdemir 4200.0
Arcelik 0.0
IKEA 1000.0
Casa 600.0
```

Sistemdeki tüm faturaları listelemek için:  
```user.listAllInvoice();```
```
List of all invoices:
11/06/2022 Invoice ID: 0 Customer ID: 0 Total Price:5300.0 Total Price with VAT: 6254.0
11/06/2022 Invoice ID: 1 Customer ID: 2 Total Price:4200.0 Total Price with VAT: 4956.0
11/06/2022 Invoice ID: 2 Customer ID: 4 Total Price:1000.0 Total Price with VAT: 1180.0
11/06/2022 Invoice ID: 3 Customer ID: 5 Total Price:600.0 Total Price with VAT: 708.0
```

Sistemde bulunan faturaları, fatura toplam tutarına göre filtrelemek için:  
```user.listInvoiceByAmount(1500, true);```
```
List of invoices that are greater than 1500
11/06/2022 Invoice ID: 0 Customer ID: 0 Total Price:5300.0 Total Price with VAT: 6254.0
11/06/2022 Invoice ID: 1 Customer ID: 2 Total Price:4200.0 Total Price with VAT: 4956.0
```


Sistemde bulunan faturaların ortalamasını verilen değere göre filtrelemek için:  
```user.getAverageByInvoice(1500, true);```
```
Average of invoices that are greater than 1500
4750.0
```

Sistemde verilen miktarın altında veya üstünde olan fatura sahiplerinin isimlerini listelemek için:  
```user.listCustomerByInvoice(500, false);```
```
List of customers that has invoices less than 500
```

Sistemde kayıt edilen fatura tarihine göre ortalaması verilen miktarın üstünde veya altında olan firmaların sektörlerini listelemek için:  
```user.listSectorByAverageInvoice(5, 750, false);```
```
List of customer sectors that customer has average invoices less than 750 in month: JUNE
Furniture
```






