package dev.be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *[중요] `ModuleApiApplication` Package Path 변경 : 하위 Module에 존재하는 Bean Scan을 위한 조치
 *
 * ``` java
 * package dev.be.ModuleApiApplication
 * ```
 *
 * - module-api는 module-common을 참조하여 사용한다.
 * - module-common에 선언되어있는 Bean을 사용하기 위해선 Component Scan이 필요하다.
 *
 * - module-api 프로젝트에서 Component Scan은 `dev.be` path를 기준으로 이뤄진다.
 * - Component Scan이 시작될 때 module-common에서도 동일한 path를 기준으로 Component Scan이 이뤄진다.
 * - 즉 module-common.dev.be를 찾아 Scan이 이뤄진다.
 *
 * - 만약 `ModuleApiApplication`가 `dev.be.moduleapi`에 존재한다면 module-common에서는 해당 path를 찾을 수 없다.
 * - 그러므로 module-common에 존재하는 Bean을 주입받을 수 없게 된다.
 */
@SpringBootApplication
public class ModuleApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleApiApplication.class, args);
    }

}
