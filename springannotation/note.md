1. 加入 Dependency spring-context

    `<dependency>
                 <groupId>org.springframework</groupId>
                 <artifactId>spring-context</artifactId>
                 <version>4.3.12.RELEASE</version>
             </dependency>`
             
 2. Specify @BootstrapWith's 'value' attribute or make the default bootstrapper class available
    如果遇到这个错误请更新spring-context 的本版号。