[![Main branch build status](https://github.com/grace-guides/gs-jooq/workflows/Grace%20CI/badge.svg?style=flat)](https://github.com/grace-guides/gs-jooq/actions?query=workflow%3A%Grace+CI%22)
[![Apache 2.0 license](https://img.shields.io/badge/License-APACHE%202.0-green.svg?logo=APACHE&style=flat)](https://opensource.org/licenses/Apache-2.0)
[![Grace on X](https://img.shields.io/twitter/follow/graceframework?style=social)](https://x.com/graceframework)

[![Groovy Version](https://img.shields.io/badge/Groovy-4.0.24-blue?style=flat&color=4298b8)](https://groovy-lang.org/releasenotes/groovy-4.0.html)
[![Grace Version](https://img.shields.io/badge/Grace-2023.2.0-blue?style=flat&color=f49b06)](https://github.com/graceframework/grace-framework/releases/tag/v2023.2.0)
[![Spring Boot Version](https://img.shields.io/badge/Spring_Boot-3.2.12-blue?style=flat&color=6db33f)](https://github.com/spring-projects/spring-boot/releases/tag/v3.2.12)


# Grace and jOOQ

## Grace Version

* Grace v2023.2.0

## Add jooq to build.gradle

In `buildSrc/build.gradle`,

```groovy
dependencies {
    implementation "org.jooq:jooq-codegen-gradle:3.19.12"
}
```

In `build.gradle`,

```groovy
// Use latest JOOQ 3.19.12
ext['jooq.version'] = '3.19.12'


dependencies {
    jooqCodegen "com.h2database:h2:2.1.214"
    implementation "org.springframework.boot:spring-boot-starter-jooq", {
        exclude group: 'org.jooq', module: 'jooq'
    }
    implementation "org.jooq:jooq:3.19.12"
}
```

## Configure jooq task to generate database schema

```groovy
jooq {
    configuration {
        jdbc {
            url = 'jdbc:h2:file:./build/gs_jooq_dev'
            username = 'sa'
            password = ''
            initScript = 'src/main/resources/db/migration/V1__INIT.sql'
        }
        generator {
            database {
                inputSchema = 'PUBLIC'
            }
            target {
                packageName = 'grace.guides.db'
            }
        }
    }
}

sourceSets {
    main {
        java {
            srcDirs += ['build/generated-sources/jooq']
        }
    }
}
```

## Configure DataSource for Hibernate

```yml
environments:
    development:
        dataSource:
            dbCreate: create-drop
            url: jdbc:h2:file:./build/gs_jooq_dev;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE

## or Use Spring DataSource
spring:
    datasource:
        url: jdbc:h2:file:./build/gs_jooq_dev;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE
        username: sa
        password: ''
```

## Use jOOQ DSLContext in Service

```groovy
import grace.guides.db.Tables
import org.jooq.DSLContext

class PostService {

    DSLContext dslContext

    def list() {
        this.dslContext.selectFrom(Tables.POSTS).asList()
    }
}
```

## Running the app

```bash
$ ./gradlew bootRun
```

Then, Go to the browser and click [http://localhost:8080/post/index](http://localhost:8080/post/index)


## Links

- [Grace Framework](https://github.com/graceframework/grace-framework)
- [Grace Plugins](https://github.com/grace-plugins)
- [Grace Guides](https://github.com/grace-guides)
