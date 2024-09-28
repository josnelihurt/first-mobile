FROM node:14

# Install quicktype
RUN npm install -g quicktype

# Set the working directory
WORKDIR /app

# Default command
ENTRYPOINT ["quicktype"]