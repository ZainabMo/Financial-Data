FROM docker.io/openjdk:8u171-jre

ENV USER_NAME docker
ENV APP_HOME /home/$USER_NAME/app

RUN useradd -ms /bin/bash $USER_NAME && mkdir $APP_HOME

ADD financial-data-1.0.0.jar $APP_HOME/app.jar
COPY entrypoint.sh $APP_HOME/

RUN chown $USER_NAME $APP_HOME/app.jar && \
    bash -c 'touch app.jar' && \
    chown $USER_NAME $APP_HOME/entrypoint.sh && \
    chmod +x $APP_HOME/entrypoint.sh

USER $USER_NAME
WORKDIR $APP_HOME

EXPOSE 8080

ENTRYPOINT [ "/home/docker/app/entrypoint.sh" ]