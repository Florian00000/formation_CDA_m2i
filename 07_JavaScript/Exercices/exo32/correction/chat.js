export default class Chat {
  static count = 0;

  constructor(name, breed, birthDate) {
    this.id = ++Chat.count;
    this.name = name;
    this.breed = breed;
    this.birthDate = birthDate;
  }
}
