FROM debian:9

MAINTAINER Ivan Ermilov <ivan.s.ermilov@gmail.com>
MAINTAINER Giannis Mouchakis <gmouchakis@iit.demokritos.gr>

RUN apt-get update && DEBIAN_FRONTEND=noninteractive apt-get install -y --no-install-recommends \
      openjdk-8-jdk \
      net-tools \
      curl \
      netcat \
      gnupg \
    && rm -rf /var/lib/apt/lists/*
      
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64/

RUN curl -O https://dist.apache.org/repos/dist/release/hadoop/common/KEYS

RUN gpg --import KEYS

ENV HADOOP_VERSION 3.2.1
ENV HADOOP_URL https://www.apache.org/dist/hadoop/common/hadoop-$HADOOP_VERSION/hadoop-$HADOOP_VERSION.tar.gz

RUN set -x \
    && curl -fSL "$HADOOP_URL" -o /tmp/hadoop.tar.gz \
    && curl -fSL "$HADOOP_URL.asc" -o /tmp/hadoop.tar.gz.asc \
    && gpg --verify /tmp/hadoop.tar.gz.asc \
    && tar -xvf /tmp/hadoop.tar.gz -C /opt/ \
    && rm /tmp/hadoop.tar.gz*

RUN ln -s /opt/hadoop-$HADOOP_VERSION/etc/hadoop /etc/hadoop

RUN mkdir /opt/hadoop-$HADOOP_VERSION/logs

RUN mkdir /hadoop-data

ENV HADOOP_HOME=/opt/hadoop-$HADOOP_VERSION
ENV HADOOP_CONF_DIR=/etc/hadoop
ENV MULTIHOMED_NETWORK=1
ENV USER=root
ENV PATH $HADOOP_HOME/bin/:$PATH

#install pig-0.17.0
RUN curl -LO http://mirror.vorboss.net/apache/pig/pig-0.17.0/pig-0.17.0.tar.gz
RUN tar xzf pig-0.17.0.tar.gz

# #install npm
RUN apt-get update
RUN curl -sL https://deb.nodesource.com/setup_12.x | bash -
RUN apt-get install -y nodejs

# # to run bower as root
RUN echo '{ "allow_root": true }' > /root/.bowerrc

# # install maven
# RUN curl -s http://mirror.linux-ia64.org/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz | tar -xz -C /usr/local/
# RUN cd /usr/local && ln -s apache-maven-3.6.3 maven
# ENV MAVEN_HOME /usr/local/maven
# ENV PATH $MAVEN_HOME/bin:$PATH

# #install protobuf
# # dev tools to build tez
RUN apt-get update
RUN apt-get install -y gcc g++ make yarn maven
#
RUN curl -LO https://github.com/protocolbuffers/protobuf/releases/download/v2.5.0/protobuf-2.5.0.tar.gz
RUN tar xzf protobuf-2.5.0.tar.gz -C /opt/
RUN cd /opt/protobuf-2.5.0/
RUN /opt/protobuf-2.5.0/configure --prefix=/usr/local/
RUN make
RUN make install
RUN export LD_LIBRARY_PATH=/usr/local/lib
# RUN /sbin/ldconfig -v
# # protobuf-2.5.0

# # download tez code, compile and copy jars
ENV TEZ_VERSION 0.10.1-SNAPSHOT
ENV TEZ_DIST /usr/local/tez/tez-dist/target/tez-${TEZ_VERSION}
RUN apt-get install -y git
RUN cd /usr/local && git clone https://github.com/apache/tez.git
RUN cd /usr/local/tez && mvn clean package -DskipTests=true -Dhadoop.version=3.2.1 -Dmaven.javadoc.skip=true
# #RUN $BOOTSTRAP && $HADOOP_PREFIX/bin/hadoop dfsadmin -safemode leave && $HADOOP_PREFIX/bin/hdfs dfs -put ${TEZ_DIST} /tez

ENV HADOOP_PREFIX=$HADOOP_HOME
# environment settings
RUN echo 'TEZ_JARS=${TEZ_DIST}/*' >> $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
RUN echo 'TEZ_LIB=${TEZ_DIST}/lib/*' >> $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
RUN echo 'TEZ_CONF=/usr/local/hadoop/etc/hadoop' >> $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
RUN echo 'export HADOOP_CLASSPATH=$HADOOP_CLASSPATH:$TEZ_CONF:$TEZ_JARS:$TEZ_LIB' >> $HADOOP_PREFIX/etc/hadoop/hadoop-env.sh
ADD tez-site.xml  $HADOOP_PREFIX/etc/hadoop/tez-site.xml

RUN rm -v /pig-0.17.0/lib/h2/tez-*.jar
RUN cp -v ${TEZ_DIST}/tez-*.jar /pig-0.17.0/lib/h2/

ENV PATH $PATH:/pig-0.17.0/bin

ADD entrypoint.sh /entrypoint.sh

RUN chmod a+x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
