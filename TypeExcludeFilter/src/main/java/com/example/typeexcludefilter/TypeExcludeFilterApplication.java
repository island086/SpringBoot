package com.example.typeexcludefilter;

import com.example.typeexcludefilter.component.A;
import com.example.typeexcludefilter.filter.CustomerTypeExcludeFilter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;

import java.util.Collection;

@SpringBootApplication
public class TypeExcludeFilterApplication {

    public static void main(String[] args) {
//        SpringApplication.run(TypeExcludeFilterApplication.class, args);


        SpringApplication springApplication = new SpringApplication(TypeExcludeFilterApplication.class);
        //添加Initializer
        springApplication.addInitializers(new CustomerTypeExcludeFilterApplicationContextInitializer());
        ConfigurableApplicationContext applicationContext = springApplication.run(args);


//        test
        System.out.println("applicationContext.getBean(\"a\",String.class) = " + applicationContext.getBean("aaa", String.class));
        System.out.println("applicationContext.getBean(A.class) = " + applicationContext.getBean(A.class));

        Collection<TypeExcludeFilter> values = applicationContext.getBeansOfType(TypeExcludeFilter.class).values();
        values.forEach(System.out::println);
    }


    /**
     * 自定义ApplicationContextInitializer
     */
    public static class CustomerTypeExcludeFilterApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            applicationContext.addBeanFactoryPostProcessor(new CustomerTypeExcludeFilterPostProcessor());
        }

    }

    /**
     * 自定义BeanPostProcessor
     */
    private static class CustomerTypeExcludeFilterPostProcessor
            implements PriorityOrdered, BeanDefinitionRegistryPostProcessor {

        public static final String BEAN_NAME = CustomerTypeExcludeFilter.class.getName(); //获取类的全路径名

        @Override
        public int getOrder() {
            return Ordered.HIGHEST_PRECEDENCE;
        }
        @Override
        public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
            // TODO Auto-generated method stub

        }
        @Override
        public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
            RootBeanDefinition definition = new RootBeanDefinition(
                    CustomerTypeExcludeFilter.class);
            registry.registerBeanDefinition(BEAN_NAME, definition);
        }
    }

}
