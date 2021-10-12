package fm.products.stockoverflow.utils

import fm.products.stockoverflow.database.enteties.Stock
import fm.products.stockoverflow.networking.models.PolygonStock


fun PolygonStock.toStock() = Stock(id, type, name, acronym, mic, operatingMic, participantId, url)