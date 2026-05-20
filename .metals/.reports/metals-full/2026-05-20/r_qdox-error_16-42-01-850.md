error id: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-trabajo8/hospital/Main.java
file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-trabajo8/hospital/Main.java
### com.thoughtworks.qdox.parser.ParseException: syntax error @[24,27]

error in qdox parser
file content:
```java
offset: 790
uri: file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-trabajo8/hospital/Main.java
text:
```scala
package hospital;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        VectorHeap<Paciente> cola = new VectorHeap<>();

        
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    if (linea.trim().isEmpty()) continue;
                    String[] partes = linea.split(",");
                    cola.add(new Paciente(partes[0], partes[1], partes[2].trim().charAt(0)));
                }
            } catch (IOException e) {
                System.out.println("Error al leer el archivo: " + e.getMessage());
            }
        }

        System.out.println(@@"=== Emergencias (VectorHeap) — " + cola.size() + " pacientes ===\n");

        Scanner scanner = new Scanner(System.in);
        while (!cola.isEmpty()) {
            System.out.println("Siguiente: " + cola.peek());
            System.out.print("ENTER para atender, 'q' para salir: ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("q")) break;
            System.out.println(">>> ATENDIENDO: " + cola.remove() + "\n");
        }

        if (cola.isEmpty()) System.out.println("No hay más pacientes.");
        scanner.close();
    }
}
```

```



#### Error stacktrace:

```
com.thoughtworks.qdox.parser.impl.Parser.yyerror(Parser.java:2025)
	com.thoughtworks.qdox.parser.impl.Parser.yyparse(Parser.java:2147)
	com.thoughtworks.qdox.parser.impl.Parser.parse(Parser.java:2006)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:232)
	com.thoughtworks.qdox.library.SourceLibrary.parse(SourceLibrary.java:190)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:94)
	com.thoughtworks.qdox.library.SourceLibrary.addSource(SourceLibrary.java:89)
	com.thoughtworks.qdox.library.SortedClassLibraryBuilder.addSource(SortedClassLibraryBuilder.java:162)
	com.thoughtworks.qdox.JavaProjectBuilder.addSource(JavaProjectBuilder.java:174)
	scala.meta.internal.mtags.JavaMtags.indexRoot(JavaMtags.scala:49)
	scala.meta.internal.metals.SemanticdbDefinition$.foreachWithReturnMtags(SemanticdbDefinition.scala:99)
	scala.meta.internal.metals.Indexer.indexSourceFile(Indexer.scala:560)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3(Indexer.scala:691)
	scala.meta.internal.metals.Indexer.$anonfun$reindexWorkspaceSources$3$adapted(Indexer.scala:688)
	scala.collection.IterableOnceOps.foreach(IterableOnce.scala:630)
	scala.collection.IterableOnceOps.foreach$(IterableOnce.scala:628)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1313)
	scala.meta.internal.metals.Indexer.reindexWorkspaceSources(Indexer.scala:688)
	scala.meta.internal.metals.MetalsLspService.$anonfun$onChange$2(MetalsLspService.scala:940)
	scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.scala:18)
	scala.concurrent.Future$.$anonfun$apply$1(Future.scala:691)
	scala.concurrent.impl.Promise$Transformation.run(Promise.scala:500)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

QDox parse error in file:///C:/Users/Jair%20Morales/OneDrive%20-%20UVG/Escritorio/Progra2/Hoja-de-trabajo8/hospital/Main.java