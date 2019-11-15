let weeks = ["monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"];
let i = 0;

while (confirm(`${weeks[i]} Хотите увидеть следующий день?`)) {
    i = (i < 6) ? (i = i + 1) : i = 0;
}
