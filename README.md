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
  <img src="https://i.ibb.co/N97tG2B/ubb2.png" alt="SUML Diagram for Diamond Problem"/>
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
  - TreeSet: Elementlerin artan sırayla tutulduğu veri yapısıdır.
- Map: Key,Value anahtar değer yapısına sahip veri yapısıdır. Dict özelliklerini taşır.
  - TreeMap: Key value artan şekilde verileri tutar.
  - HashTable: HashMap'ten farkı senkronize olmasıdır. Null değer almaz.
  - LinkedHashMap: HashMap özelliklerine ek olarak, ekleme sırasına göre verileri tutar.
  - HashMap: Map interface'inin temel implementasyonudur. Rastgele memory'de yer tutar.

**5. Uygulama**
TBC

