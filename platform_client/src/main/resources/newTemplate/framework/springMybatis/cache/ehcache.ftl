<ehcache>

    <!-- Sets the path to the directory where cache .data files are created.
        If the path is a Java System Property it is replaced by its value in the
        running VM. The following properties are translated: user.home - User's home
        directory user.dir - User's current working directory java.io.tmpdir - Default
        temp file path <diskStore path="java.io.tmpdir/com/oztime"/> -->

    <diskStore path="user.dir/cachevar" />
    <!--Default Cache configuration. These will applied to caches programmatically
        created through the CacheManager. The following attributes are required:
        maxElementsInMemory - Sets the maximum number of objects that will be created
        in memory eternal - Sets whether elements are eternal. If eternal, timeouts
        are ignored and the element is never expired. overflowToDisk - Sets whether
        elements can overflow to disk when the in-memory cache has reached the maxInMemory
        limit. The following attributes are optional: timeToIdleSeconds - Sets the
        time to idle for an element before it expires. i.e. The maximum amount of
        time between accesses before an element expires Is only used if the element
        is not eternal. Optional attribute. A value of 0 means that an Element can
        idle for infinity. The default value is 0. timeToLiveSeconds - Sets the time
        to live for an element before it expires. i.e. The maximum time between creation
        time and when an element expires. Is only used if the element is not eternal.
        Optional attribute. A value of 0 means that and Element can live for infinity.
        The default value is 0. diskPersistent - Whether the disk store persists
        between restarts of the Virtual Machine. The default value is false. diskExpiryThreadIntervalSeconds-
        The number of seconds between runs of the disk expiry thread. The default
        value is 120 seconds. -->

    <defaultCache maxElementsInMemory="10000" overflowToDisk="true"
                  eternal="false" memoryStoreEvictionPolicy="LRU"
                  diskExpiryThreadIntervalSeconds="600" timeToIdleSeconds="3600"
                  timeToLiveSeconds="100000" diskPersistent="false" />
    <!-- 开发者定义cache -->
    <cache name="myCache"
           maxElementsInMemory="1000"
           maxElementsOnDisk="0"
           eternal="false"
           overflowToDisk="false"
           diskPersistent="false"
           timeToIdleSeconds="120"
           timeToLiveSeconds="300"
           diskSpoolBufferSizeMB="50"
           diskExpiryThreadIntervalSeconds="120"
           memoryStoreEvictionPolicy="LFU" />
</ehcache>