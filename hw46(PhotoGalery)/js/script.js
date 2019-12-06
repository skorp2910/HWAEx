'use strict';
let photosCars = ["photo_avto/_peugeot1.jpg", "photo_avto/audi-tt-sportback.jpg", "photo_avto/AUDI_TT_S-LINE.jpg", "photo_avto/bmv_MG.jpg", "photo_avto/bmw-m3.jpg",
    "photo_avto/citroen3.jpg", "photo_avto/citroen_c1s.jpg", "photo_avto/Citroen_picasso.jpg", "photo_avto/Dacia-Sandero.jpg", "photo_avto/honda-hr-v.jpg",
    "photo_avto/honda-hrv.jpg", "photo_avto/Honda_shuttle.jpg", "photo_avto/honda_vezel.jpg", "photo_avto/honda_vezel2.jpg",
    "photo_avto/Lexus-LS.jpg", "photo_avto/mercedes--g-class.jpg", "photo_avto/mercedes-amg.jpg", "photo_avto/mers1.jpg",
    "photo_avto/mers2.jpg", "photo_avto/mitsubishi-eclipse.png", "photo_avto/nissan3.jpg", "photo_avto/nissan4.jpg",
    "photo_avto/nissan-leaf2.jpg", "photo_avto/pegout8.png", "photo_avto/peugeot308.jpg",
    "photo_avto/Peugeot_208.jpg", "photo_avto/Policie_Skoda_Octavia.jpg", "photo_avto/renault6.jpg", "photo_avto/Renault-Alpine-A110.jpg",
    "photo_avto/renault-captur.jpg", "photo_avto/Renault-Scenic.jpeg", "photo_avto/renault-talismanjpg.jpg", "photo_avto/renault_clio.jpg",
    "photo_avto/reno5.jpg", "photo_avto/Skoda-Laura.jpg", "photo_avto/Skoda_Fabia1.jpg", "photo_avto/skoda_fabia8.jpg",
    "photo_avto/Skoda_Fabia_Yellow.jpg", "photo_avto/skoda_octavia.jpg", "photo_avto/skoda_octavia3.jpg", "photo_avto/skoda_octavia8.jpg",
    "photo_avto/Skoda_Octavia_5.jpg", "photo_avto/skoda_rapid.jpg", "photo_avto/skoda_rapid2.jpeg", "photo_avto/skoda_rapid3.jpg",
    "photo_avto/toyota.jpg", "photo_avto/toyota-86.jpg", "photo_avto/toyota-fj-cruiser.jpg", "photo_avto/Toyota-vitz.jpg",
    "photo_avto/volkswagen-golf.jpg", "photo_avto/volkswagen-s.jpg"];
let timerId;

class Gallery {
    constructor(photosCars) {
        this.photosCars = photosCars;
    }

    static nextImg() {
        if (i >= gallery.photosCars.length) {
            i = 0;
            imgElem.src = gallery.photosCars[i++];
        } else {
            imgElem.src = gallery.photosCars[i++];
        }
        Gallery.statistic();
    }

    static prevImg() {
        if (i > 0) {
            imgElem.src = gallery.photosCars[i - 2];
            i--;
        }
        if (i === 0) {
            i = gallery.photosCars.length;
            imgElem.src = gallery.photosCars[--i];
            ++i;
        }
        Gallery.statistic();
    }


    static runSlide() {
        let DELAY;
        let reg = /^[0-9]+$/;
        let time = prompt("Задайте время перехода между изображениями(сек.): ");
        if (reg.test(time)) {
            DELAY = +time * 1000;
            timerId = setInterval(function () {
                Gallery.nextImg();
                Gallery.fade(imgElem, 1000, 50);
                Gallery.statistic();
            }, DELAY);
        } else {
            alert("Введите цифровое значение!")
        }

    }

    static stopSlide() {
        clearInterval(timerId);
    };

    static statistic() {
        numberNumbers[0].innerHTML = ` ${i} in ${gallery.photosCars.length}`;
    }

    static fade(elem, t, f) {
        // кадров в секунду (по умолчанию 50)
        let fps = f || 50;
        // время работы анимации (по умолчанию 500мс)
        let time = t || 500;
        // сколько всего покажем кадров
        let steps = time / (1000 / fps);
        // текущее значение opacity - изначально 0
        let op = 0;
        // изменение прозрачности за 1 кадр
        let d0 = 1 / steps;

        // устанавливаем интервал (1000 / fps)
        // например, 50fps -> 1000 / 50 = 20мс
        let timer = setInterval(function () {
            // увеличивам текущее значение opacity
            op += d0;
            // устанавливаем opacity элементу DOM
            elem.style.opacity = op;
            // уменьшаем количество оставшихся шагов анимации
            steps--;

            // если анимация окончена
            if (steps <= 0) {
                // убираем интервал выполнения
                clearInterval(timer);
            }
        }, (1000 / fps));
    }
}

let gallery = new Gallery(photosCars);

let nextBtn = document.getElementById('next_photo');
let previousBtn = document.getElementById('previous_photo');
let runSlide = document.getElementById('run_slideshow');
let stopSlide = document.getElementById('stop_slideshow');
let imgElem = document.getElementById("car");
let numberNumbers = document.getElementsByClassName('numbers');

let i = 51;
nextBtn.onclick = Gallery.nextImg;

previousBtn.onclick = Gallery.prevImg;

runSlide.onclick = Gallery.runSlide;

stopSlide.onclick = Gallery.stopSlide;

Gallery.statistic();


