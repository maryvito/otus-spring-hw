package com.example.bookssecurity.conf;


import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.security.acls.domain.IdentityUnavailableException;
import org.springframework.security.acls.domain.ObjectIdentityImpl;
import org.springframework.security.acls.model.ObjectIdentity;
import org.springframework.security.acls.model.ObjectIdentityGenerator;
import org.springframework.security.acls.model.ObjectIdentityRetrievalStrategy;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;


import java.io.Serializable;
import java.lang.reflect.Method;

public class ProxyAwareObjectIdentityRetrievalStrategy implements ObjectIdentityRetrievalStrategy, ObjectIdentityGenerator {

    @Override
    public ObjectIdentity createObjectIdentity(Serializable id, String type) {
        return new ObjectIdentityImpl(type, id);
    }

    @Override
    public ObjectIdentity getObjectIdentity(Object domainObject) {
        return new ObjectIdentityImpl(deproxy(domainObject));
    }

    public static Object deproxy(Object obj) {
        Hibernate.initialize(obj);

        if (obj == null) {
            return null;
        }

        if (HibernateProxy.class.isInstance(obj)) {
            HibernateProxy proxy = (HibernateProxy) obj;
            return proxy.getHibernateLazyInitializer().getImplementation();
        }

        return obj;
    }




}
