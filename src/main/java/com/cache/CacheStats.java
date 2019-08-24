package com.cache;

import com.def.ApiConstants;
import com.def.ServiceData;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.concurrent.atomic.AtomicLong;

@XmlRootElement(name = "cacheStats", namespace = ApiConstants.V1_NAMESPACE)
@XmlType(name = "cacheStats", namespace = ApiConstants.V1_NAMESPACE)
public class CacheStats implements ServiceData {

    private static final long serialVersionUID = 7602377800558626201L;

    private AtomicLong evictionCount = new AtomicLong(0);

    private AtomicLong hitCount = new AtomicLong(0);

    private AtomicLong loadCount = new AtomicLong(0);

    private AtomicLong missCount = new AtomicLong(0);

    private Long totalLoadTime = new Long(0);

    public Double getHitRate() {
        return getRequestCount() == 0 ? 1.0 : (double) hitCount.longValue() / getRequestCount();
    }

    public Double getMissRate() {
        return getRequestCount() == 0 ? 1.0 : (double) missCount.longValue() / getRequestCount();
    }

    public Long getRequestCount() {
        return hitCount.longValue() + missCount.longValue();
    }

    public Long getTotalLoadTime() {
        return totalLoadTime;
    }

    public void setTotalLoadTime(Long totalLoadTime) {
        this.totalLoadTime = totalLoadTime;
    }

    public AtomicLong getHitCount() {
        return hitCount;
    }

    public void setHitCount(AtomicLong hitCount) {
        this.hitCount = hitCount;
    }

    public AtomicLong getEvictionCount() {
        return evictionCount;
    }

    public void setEvictionCount(AtomicLong evictionCount) {
        this.evictionCount = evictionCount;
    }

    public AtomicLong getLoadCount() {
        return loadCount;
    }

    public void setLoadCount(AtomicLong loadCount) {
        this.loadCount = loadCount;
    }

    public AtomicLong getMissCount() {
        return missCount;
    }

    public void setMissCount(AtomicLong missCount) {
        this.missCount = missCount;
    }

}
