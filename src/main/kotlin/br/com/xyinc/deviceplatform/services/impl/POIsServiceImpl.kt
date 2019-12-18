package br.com.xyinc.deviceplatform.services.impl

import br.com.xyinc.deviceplatform.documents.PointOfInterest
import br.com.xyinc.deviceplatform.repositories.PointsRepositories
import br.com.xyinc.deviceplatform.services.POIsService
import org.springframework.stereotype.Service

@Service
class POIsServiceImpl (val pointRepository: PointsRepositories) : POIsService{

    override fun persistPoint(POIs: PointOfInterest): PointOfInterest = pointRepository.save(POIs)

    override fun getPointByCoordinate(poiX: Int, poiY: Int): PointOfInterest? = pointRepository.findByCoordinate(poiX, poiY)

    override fun getPointByName(name: String): PointOfInterest? = pointRepository.findByName(name)

    override fun getAllPoints(): List<PointOfInterest>? = pointRepository.findAll().toList()

    override fun getAdjacentPoints(coordX: Int, coordY: Int): List<PointOfInterest>? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    
    override fun removePoint(poiX: Int, poiY: Int) = pointRepository.delete(pointRepository.findByCoordinate(poiX, poiY))

}