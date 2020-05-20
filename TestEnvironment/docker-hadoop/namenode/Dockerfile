FROM my/hadoop-cluster:latest

MAINTAINER Ivan Ermilov <ivan.s.ermilov@gmail.com>

HEALTHCHECK CMD curl -f http://localhost:9870/ || exit 1

ENV HDFS_CONF_dfs_namenode_name_dir=file:///hadoop/dfs/name
RUN mkdir -p /hadoop/dfs/name
VOLUME /hadoop/dfs/name


ADD run.sh /run.sh
RUN chmod a+x /run.sh

EXPOSE 9870

CMD ["/run.sh"]

ENV TEZ_VERSION 0.10.1-SNAPSHOT
ENV TEZ_DIST /usr/local/tez/tez-dist/target/tez-${TEZ_VERSION}
RUN $HADOOP_HOME/bin/hdfs dfs -mkdir -p /lib/tez/
RUN $HADOOP_HOME/bin/hdfs dfs -put ${TEZ_DIST}.tar.gz /lib/tez/tez.tar.gz
