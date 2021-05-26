FROM postgres:latest

RUN useradd -ms /bin/bash newuser && echo newuser:1234pass | chpasswd

USER newuser