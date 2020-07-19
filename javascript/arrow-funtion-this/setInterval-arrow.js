function ConstructorSample() {
  this.count = 1;
  setInterval(() => {
    this.count++;
  }, 1000);
}

const obj = new ConstructorSample();