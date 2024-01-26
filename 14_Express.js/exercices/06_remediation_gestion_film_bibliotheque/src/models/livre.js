const connection = require('../../config/db.js');

class Livre {

    static getLivre(livreId, callback) {
        connection.query('SELECT * FROM livres WHERE id= ?', livreId, callback)
    }

    static getAllLivres(callback) {
        connection.query('SELECT * FROM livres', callback);
    }

    static addLivre(livreData, callback) {
        connection.query('INSERT INTO livres (titre, auteur, annee_publication, disponible) VALUES ?', livreData, callback);
    }

    static updateLivre(livreId, livreData, callback) {
        connection.query('UPDATE livres SET ? WHERE id= ?', [livreData, livreId], callback);
    }

    static deleteLivre(livreId, callback) {
        connection.query('DELETE FROM livres WHERE id= ?', livreId, callback);
    }
}

module.exports = Livre;