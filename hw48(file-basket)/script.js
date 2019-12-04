window.addEventListener('load', () => {
    const trash = {
        icons: {
            'empty': 'images/basket.png',
            'full': 'images/full_basket.png'
        },
        init: function () {
            let img_basket = document.createElement('img');
            img_basket.src = this.icons['empty'];
            img_basket.alt = 'basket';

            img_basket.style.position = 'absolute';
            img_basket.style.width = '60px';
            img_basket.style.top = '520px';
            img_basket.style.left = '720px';
            img_basket.style.marginBottom = '';

            img_basket.id = 'basket';
            this.img = img_basket;
            this.draw();
        },

        draw: function () {
            document.body.appendChild(this.img);
        }
    };


    const file = {
        icon: 'images/file.png',

        init: function () {
            let img_file = document.createElement('img');
            img_file.alt = 'file';
            img_file.src = this.icon;

            img_file.style.position = 'absolute';
            img_file.style.top = '30px';
            img_file.style.left = '30px';
            img_file.style.width = '30px';

            img_file.addEventListener("mousedown", this.mouseDown.bind(this));

            img_file.id = 'img_file';
            this.img = img_file;
            this.draw();

        },

        mouseDown: function (e) {
            let img_file = document.getElementById('img_file');
            let shiftX = e.clientX - img_file.getBoundingClientRect().left;
            let shiftY = e.clientY - img_file.getBoundingClientRect().top;

            moveAt(e.pageX, e.pageY);

            function moveAt(pageX, pageY) {
                img_file.style.left = pageX - shiftX + 'px';
                img_file.style.top = pageY - shiftY + 'px';
            }

            document.addEventListener('keydown', function (e) {
                let basket = document.getElementById('basket');
                if (e.key === "Delete") {
                    basket.src = trash.icons.empty;
                    img_file.remove();
                }
            });

            let currentDrop = null;

            function mouseMove(e) {
                if (document.body.clientWidth < (e.pageX + (parseInt(window.getComputedStyle(img_file).width) - (shiftX + 10)))) {
                    return;
                }
                if (document.body.clientHeight < e.pageY + (parseInt(window.getComputedStyle(img_file).height) - (shiftY + 5))) {
                    return;
                }

                moveAt(e.pageX, e.pageY);
                img_file.hidden = true;
                let elemImgFile = document.elementFromPoint(e.clientX, e.clientY);
                img_file.hidden = false;

                if (!elemImgFile) return;

                let droppableImgFile = elemImgFile.closest('#basket');

                if (currentDrop !== droppableImgFile) {
                    if (currentDrop) {
                        endBasket();
                    }
                    currentDrop = droppableImgFile;
                    if (currentDrop) {
                        onBasket();
                    }
                }
            }

            document.body.addEventListener('mousemove', mouseMove);

            img_file.onmouseup = function () {
                document.body.removeEventListener('mousemove', mouseMove);
                img_file.onmouseup = null;
            };

            img_file.ondragstart = function () {
                return false;
            };

            function endBasket() {
                img_file.removeEventListener('mouseup', del);
            }

            function onBasket() {
                img_file.addEventListener('mouseup', del);
            }


            function del() {
                document.body.removeEventListener('mousemove', mouseMove);
                let basket = document.getElementById('basket');
                basket.src = trash.icons.full;
                img_file.remove();
                document.addEventListener('keydown', function (e) {
                    if (e.key === "Delete") {
                        basket.src = trash.icons.empty;
                    }
                })
            }
        },


        draw: function () {
            document.body.appendChild(this.img);
        },
    };

    trash.init();
    file.init();
});
