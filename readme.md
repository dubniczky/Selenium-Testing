# Selenium Website Testing

Testing websites in containers using selenium framework and chrome engine

## Usage Instructions

### Running using containers

Build container

```bash
docker build -t selenium-test .
```

Run container

```bash
docker run selenium-test
```

### Running locally

Install dependencies

```bash
gradle dependencies
```

Run tests

```bash
gradle dependencies
```

If you'd like to see the browser while testing, edit `test.conf` to set headless to false.
