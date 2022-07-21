package dev.be.moduleapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 *[중요] `ModuleApiApplication` Package Path 변경 : 하위 Module에 존재하는 Bean Scan을 위한 조치
 *
 * ModuleApiApplication의 위치를 변경하는 방법이 아닌
 * 명시적으로 Component Scan 범위 지정하여 Bean을 등록한다.
 *
 * scanBasePackages에서 Bean으로 등록할 Package Path를 지정해준다.
 * 그런데 JPA와 관련된 Entity와 Repository는 여기서 Scan이 되지 않는다.
 * 그래서 "@EntityScan, @EnableJpaRepositories" 어노테이션을 사용해서 등록을 시도해야 한다.
 *
 * 만약 JPA를 사용한다면
 * "@EntityScan, @EnableJpaRepositories" 어노테이션을 사용해
 * 필요한 Entity와 Repository를 Bean으로 등록한다.
 * 이렇게 명시적으로 등록해주지 않으면 Entity와 Repository는 Bean으로 등록되지 않아
 * 컴파일 시점에 Bean 주입이 실패했다는 에러가 발생한다.
 *
 * 그렇다면 scanBasePackages에서 "dev.be.modulecommon"을 등록하는 이유는 뭘까?
 * 그 이유는 api module에서 common module에 있는 일반적인 Bean을 참조할 수 있으므로
 * 그러한 Bean들을 Spring Container에 등록하기 위해 사용한다.
 * ex) CommonDemoService.class
 */
@SpringBootApplication(
        scanBasePackages = { "dev.be.moduleapi", "dev.be.modulecommon" }
)
@EntityScan("dev.be.modulecommon.domain")
@EnableJpaRepositories(basePackages = "dev.be.modulecommon.repositories")
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}
