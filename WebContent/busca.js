var Painel = function (elem) {
    //vars
    this.elem = elem;
    this.itens = [];

    //methods
    this.setItens = function () {
        this.itens = this.elem.children("[data-item]");
    };

    this.getItens = function () {
        return this.itens;
    };

    this.SelectedItens = function (itens) {
        this.itens.attr("hidden", "hidden");
        var control = true;

        for (var i = 0; i < itens.length; i++) {
            $(itens[i]).removeAttr("hidden");
        }
    };

    //constructors
    this.setItens();
};

var Field = function (id, type) {
    //vars
    this.id = id;
    this.elem = $("[data-name-field = '" + id + "']");
    this.condition;
    this.type = type;
    this.result = [];

    //methods
    this.setCondition = function () {
        if (type == "text") {
            this.condition = function (i, elem) {
                var value = this.elem.val();
                var v = elem.children("[data-field='" + this.id + "']").attr('name');

                if (value != "")
                    if (~v.toLowerCase().indexOf(value.toLowerCase())) {
                        this.addResult(elem);
                    } else {
                        this.addResult(-1);
                    }
            };
        } else {
            this.condition = function (i, elem) {
                var value = this.elem.val();
                var v = elem.children("[data-select='" + this.id + "']").attr('data-content');

                if (value != 0)
                    if (v == value) {
                        this.addResult(elem);
                    } else {
                        this.addResult(-1);
                    }
            };
        }
    };

    this.addResult = function (result) {
        this.result.push(result);
    };

    this.getResult = function (itens) {
        this.result = [];

        for (var i = 0; i < itens.length; i++)
            this.condition(i, itens.eq(i));

        if (this.isNotExist(this.result))
            return [-1];
        else
            return this.result;
    };

    this.isNotExist = function (result) {
        var control = 0;
        for (var i = 0; i < result.length; i++)
            if (result[i] == -1)
                control++;

        if (result.length == 0)
            return false;

        return (control == result.length);
    };

    this.setEvent = function (event) {
        switch (this.type) {
            case "text":
                this.elem.keyup(event);
                break;
            default:
                this.elem.change(event);
        }
    };

    //constructors
    this.setCondition();
};

var Search = function (id, fields) {
    //vars
    this.id = id;
    this.fields = fields;
    this.painel;
    this.results = [];
    var _this = this;

    //methods
    this.setPainel = function () {
        this.painel = new Painel($("[data-search='" + this.id + "'][data-painel]"));
    };

    this.setEvents = function () {
        for (var i = 0; i < this.fields.length; i++)
            this.fields[i].setEvent(this.Event);
    };

    this.Event = function () {
        _this.results = [];

        for (var i = 0; i < _this.fields.length; i++) {
            var r = _this.fields[i].getResult(_this.painel.getItens());
            if (r.length > 0)
                _this.results.push(r);
        }


        if (_this.results.length == 0) {
            _this.painel.SelectedItens(_this.painel.getItens());
        } else {
            if (_this.results[0] == -1) {
                _this.painel.SelectedItens([]);
                return;
            }

            var intersection = _this.convertDOM(_this.results[0]);
            var next;
            for (var i = 1; i < _this.results.length; i++) {
                if (_this.results[i] == -1) {
                    _this.painel.SelectedItens([]);
                    return;
                }

                next = _this.convertDOM(_this.results[i]);
                intersection = $.intersect(intersection, next);
            }

            _this.painel.SelectedItens(intersection);
        }
    };

    this.convertDOM = function (list) {
        var array = [];
        for (var k = 0; k < list.length; k++)
            array.push(list[k][0]);

        return array;
    };

    //constructors
    this.setPainel();
    this.setEvents();
};