## 1. @SpringBootApplication 
- package org.springframework.boot.autoconfigure;
- @SpringBootApplication

## 2. @EnableAutoConfiguration
- package org.springframework.boot.autoconfigure;
- @EnableAutoConfiguration

## 3. AutoConfigurationImportSelector
- package org.springframework.boot.autoconfigure;
```java
public class AutoConfigurationImportSelector implements DeferredImportSelector, BeanClassLoaderAware,
ResourceLoaderAware, BeanFactoryAware, EnvironmentAware, Ordered {}
```
